import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';

@Injectable()
export class ReviewService {
    constructor(private http: Http) {}

    submitReview(review: string) {
      return this.http.post("http://localhost:8080/api/users", review);
   }
}