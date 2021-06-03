import {BookGenre} from "./enums/bookGenre";
import {Author} from "./author";

export class Book {
  id!: number;
  title!: string;
  genre!: BookGenre;
  isbn!: string;
  pagesNumber!: number;
  numberOfCopies!: number;
  releaseDate!: Date;
  publisher!: string;
  isAvailable!: boolean;
  author!: Author;

}
