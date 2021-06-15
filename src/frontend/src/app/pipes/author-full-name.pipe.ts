import {Pipe, PipeTransform} from '@angular/core';
import {Author} from "../models/author";
import {Book} from "../models/book";

@Pipe({
  name: 'authorFullName'
})
export class AuthorFullNamePipe implements PipeTransform {

  transform(author: Author): string {
    return author.firstName + " " + author.lastName;
  }

}
