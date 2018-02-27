import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core'; 
import { CoursesService } from './courses.service';
import { FilterPipe } from './filter.pipe';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit, AfterViewInit {
  courses = []
  searchString: string;
  trysearch: string;

  constructor(private courseService: CoursesService, private route: ActivatedRoute, private filter: FilterPipe) { }

  ngOnInit() {
    this.courseService.getCourses()
    .subscribe(
      (courses: any[]) => this.courses = courses,
      (error) => console.log(error)
    );
    this.route.queryParams.subscribe(params => {
      this.searchString = params['search'] || "";
    })
    
  }

  ngAfterViewInit() {
    console.log(this.searchString);
    let searchBox = <HTMLInputElement> document.getElementById("searchBox");
    this.trysearch = this.searchString.substring(0,1);
    this.courses = this.filter.transform(this.courses, this.trysearch);
    this.trysearch = this.searchString;
    this.courses = this.filter.transform(this.courses, this.trysearch);
  }
  

  getStars(rating : string): string {
    let val = parseFloat(rating);
    let size = val/5*100;
    return size + '%';
  }

}
