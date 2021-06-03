import {Book} from "./book";

export class Author {
  id!: number;
  firstName!: string;
  lastName!: string;
  dateOfBirth!: Date;
  bookList!: Book[];
}
