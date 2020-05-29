import {Component, OnInit} from '@angular/core';
import {ConferenceService} from '../../services/conference.service';
import {Conference} from '../../models/conference.model';
import {NgbModal, NgbModalConfig, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { switchMap, map } from 'rxjs/operators';
import { combineLatest} from 'rxjs';
import { UserService } from 'src/app/services/user.service';
import { ProgramCommitteeService } from 'src/app/services/programCommittee.service';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-conferences',
  templateUrl: './all-conferences.component.html',
  styleUrls: ['./all-conferences.component.scss']
})

export class AllConferencesComponent implements OnInit {
  conferences: Conference[];
  result: Conference[];
  conference = new Conference();
  currentUser: User;

  coChairEmail: string;
  coChairsEmails = [];

  reviewerEmail: string;
  reviewerEmails = [];

  constructor(
    private modalService: NgbModal,
    private router: Router,
    private conferenceService: ConferenceService,
    private authService: AuthService,
    private userService: UserService,
    private pcService: ProgramCommitteeService
  ) { }
  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe(conf => {
      this.conferences = conf;
      this.result = conf;
      this.authService.getCurrentUser().subscribe(user => this.currentUser = user);
    });
  }

  open(content) {
    this.modalService.open(content);
  }

  saveConference(): void{  
    console.log("Before save: " + JSON.stringify(this.conference));

    let coChairsAux: User[];
    let reviewersAux: User[];
    let currentUserAux: User;

    this.authService.getCurrentUser().pipe(
      switchMap(currentUser => {
        console.log('CurrentUser');
        console.log(currentUser);
        currentUserAux = currentUser;
        const coChairsObservables = this.coChairsEmails.map(email => this.userService.getUserByEmail(email));
        return combineLatest(coChairsObservables);
      }),
      switchMap(coChairs => {
        coChairsAux = coChairs;
        console.log('CoChairs');
        console.log(coChairs);
        const reviewersObservable = this.reviewerEmails.map(email => this.userService.getUserByEmail(email));
        return combineLatest(reviewersObservable);
      }),
      switchMap(reviewers => {
        reviewersAux = reviewers;
        console.log('Reviewers');
        console.log(reviewers);
        return this.conferenceService.createConference(this.conference.title, this.conference.description);
      }),
      switchMap(conference => {
        this.conference = conference;
        console.log('Conference');
        console.log(conference);
        return this.pcService.createProgramCommittee(currentUserAux, coChairsAux, reviewersAux, this.conference.id);
      }),
    ).subscribe(
      pc => console.log(pc),
      err => console.error(err),
      () => this.router.navigate['/conference-page/' + this.conference.id]
    );
  }

  filter(event) {
    const filterKey = event.target.value;
    if (filterKey === '') {
      this.result = this.conferences;
    } else {
      this.result = this.conferences.filter(
        conference => conference.title.search(filterKey) >= 0 || 
        conference.description.search(filterKey) >= 0
      );
    }
  }
}
