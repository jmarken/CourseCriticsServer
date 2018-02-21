import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class AuthorizationService {
    constructor(private http: Http) {}

    registerUser(user: string) {
        return this.http.post("http://localhost:8080/api/users", user);
     }
}