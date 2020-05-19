import { Component, OnInit } from '@angular/core';
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

  conference = new Conference();

  constructor(
    private conferenceService: ConferenceService,
    config: NgbModalConfig,
    private modalService: NgbModal
  ) { }


  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(conf => {
      this.conferences = conf;
    });
  }
  open(content) {
    this.modalService.open(content);
  }

  saveConference(): void{
    console.log(this.conference);
  }

}
