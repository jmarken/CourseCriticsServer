import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CoursesComponent } from './courses/courses.component';
import { ReviewComponent } from './review/review.component';
import { HomeComponent } from './home/home.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { CoursepageComponent } from './courses/coursepage/coursepage.component';

const appRoutes: Routes = [
    {path: '', redirectTo: '/home', pathMatch:'full'},
    {path: 'courses/:id', component: CoursepageComponent},
    { path: 'courses', component: CoursesComponent},
    { path: 'review', component: ReviewComponent},
    { path: 'home', component: HomeComponent},
    { path: 'registeruser', component: RegisteruserComponent},
    
]
@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}