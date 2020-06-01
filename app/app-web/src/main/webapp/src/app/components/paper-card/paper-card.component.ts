import {Component, Input, OnInit} from '@angular/core';
import {Paper} from "../../models/paper.model";
import {Phase} from "../../models/phase.enum";
import {PaperAgree} from "../../models/paper.agree";
import { PaperService } from 'src/app/services/paper.service';
import { SubmissionService } from 'src/app/services/submission.service';
import { Submission } from 'src/app/models/submision.model';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';
import { EvaluationService } from 'src/app/services/evaluation.service';

@Component({
  selector: 'app-paper-card',
  templateUrl: './paper-card.component.html',
  styleUrls: ['./paper-card.component.scss']
})
export class PaperCardComponent implements OnInit {
  @Input() conferencePhase: string;
  @Input() submission: Submission;
  Phases = Phase;
  PAPER_AGREE = PaperAgree;
  // paper: Paper;
  reviewerInput: string;
  selectedInterest: string;
  selectedAgreement: Boolean;
  showTextarea: Boolean;

  constructor(
    private paperService: PaperService,
    private authService: AuthService,
    private submissionService: SubmissionService,
    private evaluationService: EvaluationService
  ) { }

  ngOnInit(): void {
    this.selectedInterest = null;
    this.selectedAgreement = false;
    this.reviewerInput = null;
    this.showTextarea = true;
  }
  submitReview(paperAgree: PaperAgree){
    console.log("Added review", paperAgree);
    this.selectedAgreement = true;
    this.showTextarea = false;
  }

  addBidding(interestLevel: string) {
    console.log(interestLevel);
    this.selectedInterest = interestLevel;
    if (interestLevel === 'not_interested')
      return;
    this.authService.getCurrentUser().subscribe(
      user => {
        this.submissionService.bidSubmission(this.submission.id, user.id, interestLevel);
      }
    );
  }

  download() {
    this.paperService.downloadPaper(this.submission.paper.id, 'abstract').subscribe(
      whatisthis => console.log(whatisthis),
      err => console.error(err),
      () => console.log('Download completed')
    );
  }
}
