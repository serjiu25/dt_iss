import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Conference } from '../models/conference.model';
import { User } from '../models/user.model';
import { ProgramCommittee } from '../models/programCommittee.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class ProgramCommitteeService {
    private programCommitteeUrl = `http://${environment.serverAddress}:8080/api/pc`;

    constructor(private httpClient: HttpClient) {
    }

    createProgramCommittee(chair: User, coChairs: User[], reviewers: User[], conferenceId: number): Observable<ProgramCommittee> {
        const pc: ProgramCommittee = {
            chair, coChairs, reviewers, conferenceId
        };
        return this.httpClient.post<ProgramCommittee>(this.programCommitteeUrl, pc);
    }

}