import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {environment} from 'src/environments/environment';
import {User} from '../models/user.model';
import {map, catchError} from 'rxjs/operators';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  isPcProfile(): boolean {
    return localStorage.getItem('profile') === "pc";
  }

  setPcProfile(): void {
    localStorage.setItem("profile", "pc");
  }

  setAuthorProfile(): void {
    localStorage.setItem("profile", "author");
  }
}
