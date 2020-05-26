import { Component, OnInit } from '@angular/core';
import {ConferenceService} from '../../services/conference.service';
import {Conference} from '../../models/conference.model';
import {NgbModal, NgbModalConfig, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import { switchMap, map } from 'rxjs/operators';
import { combineLatest} from 'rxjs';
import { UserService } from 'src/app/services/user.service';
import { ProgramCommitteeService } from 'src/app/services/programCommittee.service';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-all-conferences',
  templateUrl: './all-conferences.component.html',
  styleUrls: ['./all-conferences.component.scss']
})

export class AllConferencesComponent implements OnInit {
  conferences: Conference[];
  conference = new Conference();

  coChairEmail: string;
  coChairsEmails = [];

  constructor(
    private conferenceService: ConferenceService,
    private modalService: NgbModal,
    private authService: AuthService,
    private userService: UserService,
    private pcService: ProgramCommitteeService
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
    console.log("Before save: " + this.conference);

    let coChairsAux: User[];
    let currentUserAux: User;

    this.userService.getUserByEmail(this.coChairsEmails[0]).subscribe(res => {
      console.log(res);
      console.log(JSON.stringify(res));
    });

    return;
    // this.authService.getCurrentUser().pipe(
    //   switchMap(currentUser => {
    //     console.log('CurrentUser');
    //     console.log(currentUser);
    //     currentUserAux = currentUser;
    //     const coChairsObservables = this.coChairsEmails.map(email => this.userService.getUserByEmail(email));
    //     return combineLatest(coChairsObservables);
    //   }),
    //   switchMap(coChairs => {
    //     coChairsAux = coChairs;
    //     console.log('CoChairs');
    //     console.log(coChairs);
    //     return this.conferenceService.createConference(this.conference.title, this.conference.description);
    //   }),
    //   switchMap(conference => {
    //     this.conference = conference;
    //     console.log('Conference: ' + conference);
    //     return this.pcService.createProgramCommittee(currentUserAux, coChairsAux, this.conference.id);
    //   }),
    // ).subscribe(pc => console.log('Program committee: ' + pc));

    // this.conferenceService.createConference(this.conference.title, this.conference.description).pipe(
    //   switchMap(conference => {
    //     this.conference = conference;
    //     console.log('Conference: ' + conference);
    //     const coChairsObservables = this.coChairsEmails.map(email => this.userService.getUserByEmail(email));
    //     return combineLatest(coChairsObservables);
    //   }),
    //   switchMap(coChairs => {
    //     coChairsAux = coChairs;
    //     console.log('CoChairs: ' + coChairs);
    //     return this.authService.getCurrentUser();
    //   }),
    //   switchMap(currentUser => {
    //     console.log('CurrentUser: ' + JSON.stringify(currentUser))
    //     return this.pcService.createProgramCommittee(currentUser, coChairsAux, this.conference.id);
    //   })
    // ).subscribe(pc => console.log('Program committee: ' + pc));

  }

}
