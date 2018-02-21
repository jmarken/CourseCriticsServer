import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';

@Injectable()
export class ReviewService {
    constructor(private http: Http) {}

        getReviews(name: string) {
          return this.http.get('http://192.168.10.243:8080/api/courses/' + name + '/reviews')
          .map(
            (response: Response)=> {
                console.log("http://192.168.10.243:8080/api/courses/' + name + '/reviews'");
                const data = response.json();
                return data;
        }
      );
    }
}