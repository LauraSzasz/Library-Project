import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {BooksComponent} from "./books/books.component";
import {RecommendedComponent} from "./recommended/recommended.component";
import {RegisterComponent} from "./register/register.component";

const routes: Routes = [
  {path:'home', component: HomeComponent},
  {path:'books', component: BooksComponent},
  {path:'recommended', component: RecommendedComponent},
  {path:'register', component: RegisterComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
