import { Http, Response } from '@angular/http';
import { Injectable } from "@angular/core";

import 'rxjs/Rx';

@Injectable()
export class CoursesService {
    constructor(private http: Http) {}
    

    getCourses() {
        return this.http.get('http://localhost:8080/api/courses')
        .map(
            (response: Response)=> {
                const data = response.json();
                return data;
            }
        );
      }
}