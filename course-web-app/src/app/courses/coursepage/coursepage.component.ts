import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { CoursesService } from '../courses.service';
import { Course } from '../course.model';
import { ReviewService } from '../../review/review.service';


@Component({
  selector: 'app-coursepage',
  templateUrl: './coursepage.component.html',
  styleUrls: ['./coursepage.component.css']
})
export class CoursepageComponent implements OnInit {
  course = [];
  id: string;
  reviews = [];
  

  constructor(private courseService: CoursesService,
  private route: ActivatedRoute,
private router: Router,
private reviewService: ReviewService) { }

  ngOnInit() {
    this.route.params
    .subscribe(
      (params: Params) =>{
      this.id = params['id'] ;
      console.log(this.id);
      this.courseService.getCourse(this.id)
    .subscribe(
      (course: any[]) => this.course = course,
      (error) => console.log(error)
    );    
    
      }
    );


    this.courseService.getReview(this.id)
    .subscribe(
      (reviews: any[]) => this.reviews = reviews,
      (error) => console.log(error)
    );
    

  }


}
