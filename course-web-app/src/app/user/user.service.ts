import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class UserService {
    constructor(private http: Http) {}
    data = []

    getUsers() {
        return this.http.get('http://localhost:8080/api/users')
        .map(
            (response: Response)=> {
                this.data = response.json();
                return this.data;
            }
        );
      }

      loginUser(user: string) {
         return this.http.post("http://localhost:8080/api/users/login", user)
         .map(user => {
            // login successful if there's a jwt token in the response
            if (user) {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
            }

            return user;
        });
}
}