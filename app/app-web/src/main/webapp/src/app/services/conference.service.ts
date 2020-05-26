import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Conference} from '../models/conference.model';
import { User } from '../models/user.model';
import { Phase } from '../models/phase.enum';
import { environment } from 'src/environments/environment';

@Injectable()
export class ConferenceService {
  private conferenceUrl = `http://${environment.serverAddress}:8080/api/conferences`;

  constructor(private httpClient: HttpClient) {
  }

  getConferences(): Observable<Conference[]> {
    // return this.httpClient.get<Array<Conference>>(this.conferenceUrl);

    return of([
      new Conference(1, "Title 1 proba", "Salam idolul femeilor", 1),
      new Conference(2, "Title 2 proba", "Inainte sa moara Michael Jackson", 2),
      new Conference(3, "Title 3 nu mai e proba", "Anainte sa moara Michael Jackson", 3),
      new Conference(4, "Title 4 ie tot un fel de proba", "Pe bune zic sa moara gibi de nu", 4)
    ]);
  }

  getConference(conferenceId: number): Observable<Conference> {
    const url = this.conferenceUrl + '/' + conferenceId;
    return this.httpClient.get<Conference>(url);
  }

  createConference(title: string, description: string): Observable<Conference> {
    const conference: Conference = {
      title, description, phase: Phase.SUBMIT
    }
    return this.httpClient.post<Conference>(this.conferenceUrl, conference);
  }

  updateConference(conference: Conference): Observable<Conference> {
    const url = this.conferenceUrl + '/' + conference.id;
    return this.httpClient.put<Conference>(url, conference);
  }

  deleteConference(conferenceId: number): Observable<any> {
    const url = this.conferenceUrl + '/' + conferenceId;
    return this.httpClient.delete<any>(url);
  }

}


