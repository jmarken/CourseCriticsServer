import { Injectable } from "@angular/core";
import { Http } from '@angular/http';

@Injectable()
export class ReviewService {
    constructor(private http: Http) {}

        getUsers() {
          return this.http.get('http://192.168.10.243:8080/api/users/test/reviews')
        }
}