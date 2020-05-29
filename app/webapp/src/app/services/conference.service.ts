import { Injectable } from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Conference} from "../models/conference.model";

@Injectable()
export class ConferenceService {
  private conferenceUrl = 'http://localhost:8080/api/';

  constructor(private httpClient:HttpClient) {
  }

  getConferences(): Observable<Conference[]>{
    return of ([
      new Conference(1, "Title 1 proba", "Salam idolul femeilor"),
      new Conference(2, "Title 2 proba", "Inainte sa moara Michael Jackson"),
      new Conference(3, "Title 3 nu mai e proba", "Anainte sa moara Michael Jackson")
    ]);
  }
}


