import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../models/book";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  public saveBook(book: Book): Observable<Object>{
    return this.http.post("http://localhost:8082/books/add", book)
  }
}
