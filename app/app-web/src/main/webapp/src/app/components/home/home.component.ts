import { Component, OnInit } from '@angular/core';
import {ConferenceService} from '../../services/conference.service';
import {Conference} from '../../models/conference.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  conferences: Conference[];
  pcMemberConferences: Conference[];
  authorConferences: Conference[];
  constructor(
    private conferenceService: ConferenceService,
  ) { }

  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(conf => {
      this.conferences = conf;
    });
  }

}
