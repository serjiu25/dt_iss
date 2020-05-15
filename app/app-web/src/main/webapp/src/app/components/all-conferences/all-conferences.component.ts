import { Component, OnInit } from '@angular/core';
import {ConferenceService} from "../../services/conference.service";
import {Conference} from "../../models/conference.model";

@Component({
  selector: 'app-all-conferences',
  templateUrl: './all-conferences.component.html',
  styleUrls: ['./all-conferences.component.scss']
})

export class AllConferencesComponent implements OnInit {
  username = 'MyNameMyBack...';
  conferences: Conference[];
  constructor(
    private conferenceService: ConferenceService
  ) { }


  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(conf => {
      this.conferences = conf;
    });
  }

}
