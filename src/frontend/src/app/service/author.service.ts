import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Author} from "../models/author";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) {
  }

  saveAuthor(author: Author): Observable<Object> {
    return this.http.post("http://localhost:8082/authors/add", author);
  }

  getAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>("http://localhost:8082/authors/");
  }
}
