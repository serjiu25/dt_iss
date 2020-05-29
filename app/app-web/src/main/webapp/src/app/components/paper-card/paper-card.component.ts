import {Component, Input, OnInit} from '@angular/core';
import {Paper} from "../../models/paper.model";
import {Phase} from "../../models/phase.enum";
import {PaperAgree} from "../../models/paper.agree";

@Component({
  selector: 'app-paper-card',
  templateUrl: './paper-card.component.html',
  styleUrls: ['./paper-card.component.scss']
})
export class PaperCardComponent implements OnInit {
  @Input() conferencePhase: string;
  @Input() paper: Paper;
  Phases = Phase;
  PAPER_AGREE = PaperAgree;
  // paper: Paper;
  reviewerInput: string;
  selectedInterest: string;
  selectedAgreement: Boolean;
  showTextarea: Boolean;
  constructor() { }

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
    // alert("Thank you for your interest!");
    this.selectedInterest = interestLevel;
    // call some method
  }
}
