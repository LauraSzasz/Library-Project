import {BookGenre} from "./enums/bookGenre";
import {Author} from "./author";

export class Book {
  // constructor(
  //   public id: number,
  //   public title: string,
  //   public genre: BookGenre,
  //   public isbn: string,
  //   public pagesNumber: number,
  //   public numberOfCopies: number,
  //   public releaseDate: Date,
  //   public publisher: string,
  //   public isAvailable: boolean,
  //   public imageURL: string,
  //   public author: Author)

  id!: number;
  title!: string;
  genre!: BookGenre;
  isbn!: string;
  pagesNumber!: number;
  numberOfCopies!: number;
  releaseYear!: number;
  publisher!: string;
  isAvailable!: boolean;
  imageURL!: string;
  author!: Author;
}
