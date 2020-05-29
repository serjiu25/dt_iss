import {Component, Input, OnInit} from '@angular/core';
import {Paper} from "../../models/paper.model";
import {Phase} from "../../models/phase.enum";

@Component({
  selector: 'app-paper-card',
  templateUrl: './paper-card.component.html',
  styleUrls: ['./paper-card.component.scss']
})
export class PaperCardComponent implements OnInit {
  @Input() conferencePhase: string;
  @Input() paper: Paper;
  Phases = Phase;
  // paper: Paper;
  reviewerInput: string;
  constructor() { }

  ngOnInit(): void {
  }
  submitReview(){
    console.log("Added review", this.reviewerInput);
  }
}
