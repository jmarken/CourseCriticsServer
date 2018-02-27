import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Response } from '@angular/http'
import { ReviewService } from './review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  constructor(private router: Router, private reviewService: ReviewService) { }

  ngOnInit() {
  }

  onSubmitReview(form: NgForm) {
      const value = form.value;
      console.log(value);
      this.reviewService.submitReview(value)
      .subscribe(
      (data: any[]) => console.log(data),

      (error) => console.log(error)
    );
      this.router.navigate(['/home']);
  }

}
