import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Response } from '@angular/http/src/static_response';

import { UserService } from '../user/user.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
    const value = form.value;
    console.log(value);
    this.userService.loginUser(value)
    .subscribe(
      (response: Response) => console.log(response),
      (error)=> console.log(error)
    );
  }

}
