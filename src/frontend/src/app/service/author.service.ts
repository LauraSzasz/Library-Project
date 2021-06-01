import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Author} from "../models/author";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  private saveAuthor(author: Author): Observable<Object>{
    return this.http.post("http://localhost:8082/authors/add", author);
  }
}
