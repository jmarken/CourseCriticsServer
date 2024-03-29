import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

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
        console.log("http://localhost:8080/api/users/" +  JSON.parse(localStorage.getItem('currentUser')) + "/reviews");
      return this.http.post("http://localhost:8080/api/users/" +  JSON.parse(localStorage.getItem('currentUser')) + "/reviews", review);
   }
}