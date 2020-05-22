import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user.model';
import { map, catchError } from "rxjs/operators";

@Injectable()
export class AuthService {
    private authUrl = `http://${environment.serverAddress}:8080/api`;

    constructor(private httpClient: HttpClient) {
    }

    getCurrentUser(): Observable<User> {
        const userId = sessionStorage.getItem('currentUserId');
        const url = this.authUrl + '/users/' + userId;
        return this.httpClient.get<User>(url);
    }

    login(email: string, password: string): Observable<boolean> {
        const url = this.authUrl + '/login';
        const params = { email, password };

        return this.httpClient.post(url, params).pipe(
            map(response => {
                console.log('LOGIN response: ' + response);
                if (response == null || response == {}) {
                    return false;
                }
                const user = (response as User);
                localStorage.setItem('currentUserId', user.id.toString());
                return true;
            })
        );
    }

    register(email: string, password: string, fname: string, lname: string, affiliation: string): Observable<Boolean> {
        const url = this.authUrl + '/register';
        const name = fname + ' ' + lname;
        const params = { email, password, name, affiliation };

        return this.httpClient.post(url, params).pipe(
            map(response => {
                console.log("Register response: '" + response + "'");
                if (response == null || response === {}) {
                    return false;
                }
                const user = (response as User);
                localStorage.setItem('currentUserId', user.id.toString());
                return true;
            })
        );
    }

    logout(): void {
        localStorage.removeItem('currentUser');
    }

}
