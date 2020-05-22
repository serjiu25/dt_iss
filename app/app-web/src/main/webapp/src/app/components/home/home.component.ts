import {Component, OnInit} from '@angular/core';
import {ConferenceService} from '../../services/conference.service';
import {Conference} from '../../models/conference.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  conferences: Conference[];

  constructor(
    private conferenceService: ConferenceService,
  ) {
  }

  ngOnInit(): void {
    this.conferenceService.getConferenceByAuthor().subscribe(conf => {
      this.conferences = conf;
    });
  }

  populate() {

    if (localStorage.getItem('profile') === "author") {
      this.conferenceService.getConferenceByAuthor().subscribe(conf => {
        this.conferences = conf;
      });
    } else {
      this.conferenceService.getConferenceByPc().subscribe(conf => {
        this.conferences = conf;
      });
    }
  }
}
