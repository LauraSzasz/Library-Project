import {Component, OnInit} from '@angular/core';
import {User} from "../models/user";
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  saveUser(){
    this.userService.saveUser(this.user).subscribe( data =>{
      console.log(data);
    }, error => console.log(error));
  }

  onSubmit() {
    let response = this.userService.saveUser(this.user);
    response.subscribe()
  }

}
