import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CoursesComponent } from './courses/courses.component';
import { ReviewComponent } from './review/review.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { ReviewService } from './review/review.service';
import { UserComponent } from './user/user.component';
import {RegisteruserComponent} from './registeruser/registeruser.component'
import { UserService } from './user/user.service';
import { CoursesService } from './courses/courses.service';
import { FilterPipe } from './courses/filter.pipe';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CoursesComponent,
    ReviewComponent,
    HomeComponent,
    UserComponent,
    RegisteruserComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [ReviewService,
  UserService, CoursesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
