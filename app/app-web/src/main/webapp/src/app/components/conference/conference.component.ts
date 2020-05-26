import {Component, Input, OnInit} from '@angular/core';
import {Conference} from "../../models/conference.model";
import {ConferenceService} from "../../services/conference.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-conference',
  templateUrl: './conference.component.html',
  styleUrls: ['./conference.component.scss']
})
export class ConferenceComponent implements OnInit {
  // @Input() conference: Conference;
  conferenceId: number;
  conference: Conference;


  constructor(
    private conferenceService: ConferenceService,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.conferenceId = Number(paramMap.get('id'));
      this.conferenceService.getConference(
        this.conferenceId
      ).subscribe(obj => {
        this.conference = obj;
      });
    });
  }

}
