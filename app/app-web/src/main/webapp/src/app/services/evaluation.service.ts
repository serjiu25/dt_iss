import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Evaluation} from "../models/evaluation.model";
import { environment } from 'src/environments/environment';

@Injectable()
export class PaperService {
  private evaluationUrl = `http://${environment.serverAddress}:8080/api/evaluations`;

  constructor(private httpClient: HttpClient) {
  }

  getEvaluationsBySid(sid: number): Observable<Evaluation[]> {
    const url = this.evaluationUrl + '/s/' + sid;
    return this.httpClient.get<Array<Evaluation>>(url);
  }

  getEvaluationById(id: number): Observable<Evaluation> {
    const url = this.evaluationUrl + '/' + id;
    return this.httpClient.get<Evaluation>(url);
  }

  createEvaluation(evaluation: Evaluation): Observable<Evaluation> {// maybe change with sub fields instead of object
    return this.httpClient.post<Evaluation>(this.evaluationUrl, evaluation);
  }

  updateEvaluation(evaluation: Evaluation): Observable<Evaluation> {
    const url = this.evaluationUrl + '/' + evaluation.id;
    return this.httpClient.put<Evaluation>(url, evaluation);
  }

  deleteEvaluation(evaluationId: number): Observable<any> {
    const url = this.evaluationUrl + '/' + evaluationId;
    return this.httpClient.delete<any>(url);
  }

}
