import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgModel } from '@angular/forms/src/directives/ng_model';
import { Response } from '@angular/http'
import { Router } from '@angular/router';
import { AuthorizationService } from './authorization.service';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {

  constructor(private authorizationService: AuthorizationService, private router: Router) { }

  ngOnInit() {
  }

  

  onSignUp(form: NgForm) {
    const value = form.value;
    console.log(value);
   this.authorizationService.registerUser(value)
   .subscribe(
    (response: Response) => console.log(response),

    (error) => console.log(error)
  );
  this.router.navigate(["/home"])
  
}

}
