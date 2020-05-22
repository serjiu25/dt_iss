import {Component, OnInit} from '@angular/core';
import {ConferenceService} from '../../services/conference.service';
import {Conference} from '../../models/conference.model';
import {NgbModal, NgbModalConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-all-conferences',
  templateUrl: './all-conferences.component.html',
  styleUrls: ['./all-conferences.component.scss']
})

export class AllConferencesComponent implements OnInit {
  conferences: Conference[];
  result: Conference[];
  conference = new Conference();
  coChairEmail: string;
  coChairsEmails = new Array<string>();
  filterKey: string;

  constructor(
    private conferenceService: ConferenceService,
    config: NgbModalConfig,
    private modalService: NgbModal
  ) {
  }


  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(conf => {
      this.conferences = conf;
      this.result = conf;
    });
  }

  open(content) {
    this.modalService.open(content);
  }

  saveConference(): void {
    console.log(this.conference);
  }

  filter(event) {
    const filterKey = event.target.value;
    if (filterKey === '') {
      this.result = this.conferences;
    } else {
      // tslint:disable-next-line:max-line-length
      this.result = this.conferences.filter(conference => conference.title.search(filterKey) >= 0 || conference.description.search(filterKey) >= 0);
    }
  }
}
