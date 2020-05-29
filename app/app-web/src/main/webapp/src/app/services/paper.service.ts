import {Injectable} from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Paper} from "../models/paper.model";
import { environment } from 'src/environments/environment';

@Injectable()
export class PaperService {
  private papersUrl = `http://${environment.serverAddress}:8080/api/papers`;

  constructor(private httpClient: HttpClient) {
  }

  getPapersByCid(cid: number): Observable<Paper[]> {
    const url = this.papersUrl + '/c/' + cid;
    return this.httpClient.get<Array<Paper>>(url);
  }

  getPaperByPid(pid: number): Observable<Paper> {
    const url = this.papersUrl + '/' + pid;
    return this.httpClient.get<Paper>(url);
  }

  createPaper(paper: Paper): Observable<Paper> {// maybe change with sub fields instead of object
    return this.httpClient.post<Paper>(this.papersUrl, paper);
  }

  uploadFile(filename: string, file: File): Observable<any> {
    const formData = new FormData();
    formData.append('filename', filename);
    formData.append('file', file);

    const httpOptions = {
      headers: new HttpHeaders({
        // 'Content-Type': 'undefined'
      })
    };

    return this.httpClient.post(`http://${environment.serverAddress}:8080/api/uploadfile`, formData, httpOptions);
  }

  updatePaper(paper: Paper): Observable<Paper> {
    const url = this.papersUrl + '/' + paper.id;
    return this.httpClient.put<Paper>(url, paper);
  }

  deletePaper(paperId: number): Observable<any> {
    const url = this.papersUrl + '/' + paperId;
    return this.httpClient.delete<any>(url);
  }

}
