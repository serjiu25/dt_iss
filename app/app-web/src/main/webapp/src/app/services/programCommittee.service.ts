import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Conference } from '../models/conference.model';
import { User } from '../models/user.model';
import { ProgramCommittee } from '../models/programCommittee.model';

@Injectable()
export class ProgramCommitteeService {
    private programCommitteeUrl = 'http://localhost:8080/api/pc';

    constructor(private httpClient: HttpClient) {
    }

    createProgramCommittee(chair: User, coChairs: User[], conferenceId: number): Observable<ProgramCommittee> {
        const pc: ProgramCommittee = {
            chair, coChairs, conferenceId
        }
        return this.httpClient.post<ProgramCommittee>(this.programCommitteeUrl, pc);
    }

}