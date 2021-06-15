import {Component, OnInit} from '@angular/core';
import {Book} from "../../models/book";
import {BookService} from "../../service/book.service";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books!: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks() {
    this.bookService.getBooks().subscribe(data => {
      this.books = data;
    })
  }

}
