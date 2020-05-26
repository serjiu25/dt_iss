import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Submission} from "../models/submision.model";
import {Conference} from "../models/conference.model";

@Injectable()
export class SubmissionService {
  private submissionUrl = 'http://109.100.171.87:8080/api/submissions';

  constructor(private httpClient: HttpClient) {
  }

  getSubmissionsByCid(cid: number): Observable<Submission[]> {
    const url = this.submissionUrl + '/c/' + cid;
    return this.httpClient.get<Array<Submission>>(url);
  }

  getSubmissionById(sid: number): Observable<Submission> {
    const url = this.submissionUrl + '/' + sid;
    return this.httpClient.get<Submission>(url);
  }

  createSubmission(sub: Submission): Observable<Submission> {// maybe change with sub fields instead of object
    return this.httpClient.post<Submission>(this.submissionUrl, sub);
  }

  updateSubmission(sub: Submission): Observable<Submission> {
    const url = this.submissionUrl + '/' + sub.id;
    return this.httpClient.put<Submission>(url, sub);
  }

  deleteSubmission(submissionId: number): Observable<any> {
    const url = this.submissionUrl + '/' + submissionId;
    return this.httpClient.delete<any>(url);
  }
}
