import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  menuItems = [
    {routerLink:'home', linkName: 'Home'},
    {routerLink:'books', linkName: 'Books'},
    {routerLink: 'authors', linkName: 'Authors'},
    {routerLink:'recommended', linkName: 'We Recommend'},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
