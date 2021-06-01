import {Component, OnInit} from '@angular/core';
import {User} from "../models/user";
import {UserService} from "../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  saveUser(){
    this.userService.saveUser(this.user).subscribe( data =>{
      console.log(data);
      this.goToBooksPage();
    }, error => console.log(error));
  }

  goToBooksPage(){
    this.router.navigate(['/books']).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  onSubmit() {
    let response = this.userService.saveUser(this.user);
    response.subscribe();

  }

}
