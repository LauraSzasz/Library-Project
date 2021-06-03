import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {HomeComponent} from './navbar/home/home.component';
import {BooksComponent} from './navbar/books/books.component';
import {RecommendedComponent} from './navbar/recommended/recommended.component';
import {RegisterComponent} from './navbar/register/register.component';
import {AuthorsComponent} from './navbar/authors/authors.component';
import {AddAuthorComponent} from './navbar/authors/add-author/add-author.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    BooksComponent,
    RecommendedComponent,
    RegisterComponent,
    AuthorsComponent,
    AddAuthorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
