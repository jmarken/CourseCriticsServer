import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Response } from '@angular/http/src/static_response';

import { UserService } from '../user/user.service';
import { element } from 'protractor';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  visible: boolean = true;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
   
    const value = form.value;
    console.log(value);
    this.userService.loginUser(value)
    .subscribe(
      result => {
        console.log(result);
        if(result === true){
         let data = JSON.parse(localStorage.getItem('currentUser'));
         console.log(data); 
         if(data != null){
           console.log(true);
           console.log("Testar logged in" + this.loggedInUser());
         }
        } else{
           console.log("Wrong details")
          }
        });
     }


    loggedInUser(){
      if(JSON.parse(localStorage.getItem('currentUser')) != null){
        return true;
      }
      else {
        return false;
      }
    }

    getuser() {
      return JSON.parse(localStorage.getItem('currentUser'));
    }

    logout(): void {
      localStorage.removeItem('currentUser');
    }

    getVisibility(): void{
      if(this.visible) {
        let div = document.getElementById("userButton");
        div.style.display = "none";
        div = document.getElementById("logoutButton");
        div.style.display = "inline-block";
      }
    }


}
