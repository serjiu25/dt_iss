import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable()
export class AuthService {
    private authUrl = 'http://localhost:8080/api/';

    constructor(private httpClient: HttpClient) {
    }

    login(email: string, password: string): Observable<Boolean> {
        if (email === 'a@b.com' && password === "pass") {
            return of(true);
        } else {
            return of(false);
        }
    }


}