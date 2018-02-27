import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';
import { Http, Response } from '@angular/http';

@Injectable()
export class ReviewService {
    constructor(private http: Http) {}

        getUsers() {
          return this.http.get('http://localhost:8080/api/users')
          .map(
              (response: Response)=> {
                  const data = response.json();
                  return data;
              }
          );
        }
    submitReview(review: string) {
      return this.http.post("http://localhost:8080/api/users", review);
   }
}