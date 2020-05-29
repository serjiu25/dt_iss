import {Component, Input, OnInit} from '@angular/core';
import {Conference} from '../../models/conference.model';
import {ConferenceService} from "../../services/conference.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  @Input() conference: Conference;
  conferenceId: number;
  errors: String[];

  constructor(
    private conferenceService: ConferenceService,
    private router: Router
  ) {
  }

  ngOnInit(): void {

  }

  onSubmit(conferenceId: number) {
    this.errors = new Array<String>();
    this.conferenceId = conferenceId;
    // this.conferenceService.getConference()
    this.router.navigate(['/conference-page/' + conferenceId]);
  }

}
