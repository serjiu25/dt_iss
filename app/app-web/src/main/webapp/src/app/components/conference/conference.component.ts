import {Component, Input, OnInit} from '@angular/core';
import {Conference} from "../../models/conference.model";
import {ConferenceService} from "../../services/conference.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Paper} from "../../models/paper.model";
import {PaperService} from "../../services/paper.service";
import {Phase} from "../../models/phase.enum";
import {switchMap} from "rxjs/operators";
import {SubmissionService} from "../../services/submission.service";
import {Submission} from "../../models/submision.model";
import {AuthService} from "../../services/auth.service";
import { UserService } from 'src/app/services/user.service';
import { EvaluationService } from 'src/app/services/evaluation.service';

@Component({
  selector: 'app-conference',
  templateUrl: './conference.component.html',
  styleUrls: ['./conference.component.scss']
})
export class ConferenceComponent implements OnInit {
  // @Input() conference: Conference;
  conferenceId: number;
  conference: Conference;
  displayPaperForm = false;
  paper = new Paper();
  hardcodedPaper = new Paper();
  submissionList: Submission[];
  userId: number;
  isPc: Boolean;
  isReviewer: Boolean;
  isPcProfile: Boolean;
  submitted: Boolean = true;
  submissionsToReview: Submission[];

  constructor(
    private conferenceService: ConferenceService,
    private paperService: PaperService,
    private authService: AuthService,
    private userService: UserService,
    private submissionService: SubmissionService,
    private evaluationService: EvaluationService,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {

    // this.hardcodedPaper.name = "Title hardcoded";
    // this.hardcodedPaper.abstractUrl = "abstract";
    // this.hardcodedPaper.fullUrl = "full";
    // this.hardcodedPaper.topics = "topics";
    // this.hardcodedPaper.keywords = "keywords";
    // this.hardcodedPaper.otherAuthors = "Other authors";

    // this.paperList.push(this.hardcodedPaper);
    this.isPcProfile = this.userService.isPcProfile();
    this.route.paramMap.subscribe(paramMap => {
      this.conferenceId = Number(paramMap.get('id'));

      this.conferenceService.getConference(this.conferenceId).subscribe(conference => {
        this.conference = conference;
        this.submissionList = new Array<Submission>();
        
        if (this.conference.phase == Phase.SUBMIT || this.conference.phase == Phase.BIDDING) {
          this.submissionService.getSubmissionsByCid(this.conference.id).subscribe(submissions => {
            this.submissionList = submissions;
  
            this.authService.getCurrentUser().subscribe(user=>{
              this.userId = user.id;
              
              this.submitted = this.submissionList.find(sub => sub.author.id == user.id) !== undefined;
              this.conferenceService.isPc(this.conferenceId, this.userId).subscribe(isPc => {
                this.isPc = isPc;
              });
              this.conferenceService.isReviewer(this.conferenceId, this.userId).subscribe(isReviewer => {
                this.isReviewer = isReviewer;
              });
            });
          });
        } else if (this.conference.phase == Phase.REVIEW) {
          this.authService.getCurrentUser().subscribe(currentUser => {
            this.userId = currentUser.id;
            this.submissionService.getSubmissionsForReviewer(this.conference.id, currentUser.id).subscribe(
              submissions => {
                this.submissionsToReview = submissions;
                console.log(submissions);
                this.conferenceService.isPc(this.conferenceId, this.userId).subscribe(isPc => {
                  this.isPc = isPc;
                });
                this.conferenceService.isReviewer(this.conferenceId, this.userId).subscribe(isReviewer => {
                  this.isReviewer = isReviewer;
                });
              }
            );
          });
        }
      });
    });
  }

  nextPhase() {
    console.log('Current phase: ' + this.conference.phase);
    if (this.conference.phase == Phase.SUBMIT) 
      this.conference.phase = Phase.BIDDING;
    else if (this.conference.phase == Phase.BIDDING) {
      this.conference.phase = Phase.REVIEW;
      this.submissionService.assignSubmissions(this.conference.id);
    }
    console.log('Changed to phase: ' + this.conference.phase);

    this.conferenceService.updateConference(this.conference).subscribe(conference => this.conference = conference);
    location.reload();
  }

  onSubmit() {
    console.log(this.conference.phase);
    console.log("Added paper:");
    console.log(this.paper);
    // this.paperList.push(this.paper);

    this.paperService.createPaper(this.paper).pipe(
      switchMap(
        paper => {
          this.paper.id = paper.id;
          return this.paperService.uploadPaper(paper.id, "true", this.paper.abstractFile);
        }
      ),
      switchMap(
        name => {
          console.log('2 switch map');
          console.log(name);
          console.log(this.paper.fullFile);
          if (this.paper.fullFile) {
            console.log(this.paper.fullFile);
            return this.paperService.uploadPaper(this.paper.id, "false", this.paper.fullFile);
          }
        }
      ),
      switchMap(
        _ => this.authService.getCurrentUser()
      ),
      switchMap(
        currentUser => {
          const sub: Submission = {
            id: this.paper.id,
            author: currentUser,
            paper: this.paper,
            conferenceId: this.conferenceId
          };
          return this.submissionService.createSubmission(sub);
        }
      )
    ).subscribe(submission => {
      console.log(submission);
      this.submitted = true;
    }, error => console.log(error));
    // console.log(this.paperList);
  }

}
