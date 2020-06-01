import {Component, Input, OnInit} from '@angular/core';
import {Conference} from "../../models/conference.model";
import {ConferenceService} from "../../services/conference.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Paper} from "../../models/paper.model";
import {PaperService} from "../../services/paper.service";
import {Phase} from "../../models/phase.enum";

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
  paperList: Paper[];


  constructor(
    private conferenceService: ConferenceService,
    private paperService: PaperService,
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
    this.route.paramMap.subscribe(paramMap => {
      this.conferenceId = Number(paramMap.get('id'));
      this.conferenceService.getConference(this.conferenceId).subscribe(conference => {
        this.conference = conference;
        this.paperList = new Array<Paper>();
        this.paperService.getPapersByCid(this.conference.id).subscribe(papers => {
          this.paperList = papers;
        });
      });
    });
  }

  nextPhase(){
    console.log('Current phase: ' + this.conference.phase);
    if (this.conference.phase == Phase.SUBMIT)
      this.conference.phase = Phase.BIDDING;
    else if (this.conference.phase == Phase.BIDDING)
      this.conference.phase = Phase.REVIEW;
    console.log('Changed to phase: ' + this.conference.phase);
  }

  onSubmit() {
    console.log(this.conference.phase);
    console.log("Added paper:");
    console.log(this.paper);
    this.paperList.push(this.paper);
    console.log(this.paperList);
  }

}
