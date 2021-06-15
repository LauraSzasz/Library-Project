import {Component, OnInit} from '@angular/core';
import {Book} from "../../../models/book";
import {BookService} from "../../../service/book.service";
import {Router} from "@angular/router";
import {BookGenre} from "../../../models/enums/bookGenre";
import {Author} from "../../../models/author";
import {AuthorService} from "../../../service/author.service";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book!: Book;
  selectedAvailability!: boolean;
  selectedAuthor!: Author;
  authors!: Author[];
  // selectedGenre!: string;
  // bookGenre = BookGenre;
  // genreArray = Object.values(this.bookGenre);


  constructor(private bookService: BookService, private authorService: AuthorService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAuthors();
  }


  saveBook() {
    this.bookService.saveBook(this.book).subscribe(data => {
      console.log(data);
    }, error => console.log(error));
  }

  goToBooksPage() {
    this.router.navigate(['/books']).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  onSubmit() {
    this.saveBook();
    this.goToBooksPage();

  }

  getAuthors() {
    this.authorService.getAuthors().subscribe(data => {
      this.authors = data;
    })
  }

}
