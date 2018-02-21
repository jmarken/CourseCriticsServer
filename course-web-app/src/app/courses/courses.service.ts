import { Http, Response } from '@angular/http';
import { Injectable } from "@angular/core";

import 'rxjs/Rx';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Injectable()
export class CoursesService {
    courses = [];
    data = [];
    constructor(private http: Http) {
    }
    
    

    getCourses() {
        return this.http.get('http://localhost:8080/api/courses')
        .map(
            (response: Response)=> {
                this.courses = response.json();
                return this.courses;
            }
        );
      }

  
      getCourse(name: string) {
        return this.http.get('http://localhost:8080/api/courses/' + name)
        .map(
            (response: Response)=> {
                this.courses = response.json();
                return this.courses;
            }
        );
      }

      getReview(name: string) {
        return this.http.get('http://localhost:8080/api/courses/' + name + "/reviews")
        .map(
            (response: Response)=> {
               this.data = response.json();
                return this.data;
            }
        );
      }

      
}