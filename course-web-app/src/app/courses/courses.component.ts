import { Component, OnInit } from '@angular/core'; 
import { CoursesService } from './courses.service';
import { FilterPipe } from './filter.pipe';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses = []

  constructor(private courseService: CoursesService) { }

  ngOnInit() {
    this.courseService.getCourses()
    .subscribe(
      (courses: any[]) => this.courses = courses,
      (error) => console.log(error)
    );

  }

}
