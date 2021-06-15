import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./navbar/home/home.component";
import {BooksComponent} from "./navbar/books/books.component";
import {RecommendedComponent} from "./navbar/recommended/recommended.component";
import {RegisterComponent} from "./navbar/register/register.component";
import {AuthorsComponent} from "./navbar/authors/authors.component";
import {AddAuthorComponent} from "./navbar/authors/add-author/add-author.component";
import {AddBookComponent} from "./navbar/books/add-book/add-book.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'books', component: BooksComponent},
  {path: 'recommended', component: RecommendedComponent},
  {path: 'authors', component: AuthorsComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'addAuthor', component: AddAuthorComponent},
  {path: 'addBook', component: AddBookComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
