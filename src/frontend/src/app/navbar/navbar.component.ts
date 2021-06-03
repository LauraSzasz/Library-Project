import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  menuItems = [
    {routerLink: 'home', linkName: 'Home'},
    {routerLink: 'books', linkName: 'Books'},
    {routerLink: 'authors', linkName: 'Authors'},
    {routerLink: 'recommended', linkName: 'We Recommend'},
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
