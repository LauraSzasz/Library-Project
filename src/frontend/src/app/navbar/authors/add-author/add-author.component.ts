import {Component, OnInit} from '@angular/core';
import {Author} from "../../../models/author";
import {AuthorService} from "../../../service/author.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {

  author!: Author;

  constructor(private authorService: AuthorService, private router: Router) {
  }

  ngOnInit(): void {
  }

  saveAuthor() {
    this.authorService.saveAuthor(this.author).subscribe(data => {
      console.log(data);
      this.goToAuthorsPage();
    }, error => console.log(error));
  }

  goToAuthorsPage(){
    this.router.navigate(['/authors']).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  onSubmit() {
    let response = this.saveAuthor();
  }
}
