import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {environment} from 'src/environments/environment';
import {User} from '../models/user.model';
import {map, catchError} from 'rxjs/operators';

@Injectable()
export class UserService {
  private userUrl = `http://${environment.serverAddress}:8080/api/users`;

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

  getUserById(id: number): Observable<User> {
    const url = this.userUrl + '/' + id;
    return this.httpClient.get<User>(url);
  }

  getUserByEmail(email: string): Observable<any> {
    const url = this.userUrl + '/email/' + email;
    return this.httpClient.get<any>(url);
  }
}
