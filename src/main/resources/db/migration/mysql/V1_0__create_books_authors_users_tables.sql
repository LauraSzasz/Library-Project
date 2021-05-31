create table if not exists authors
(
    author_id     integer primary key auto_increment,
    first_name    VARCHAR(15),
    last_name     VARCHAR(20),
    date_of_birth DATE

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;


create table if not exists books
(
    book_id          integer primary key auto_increment,
    title            VARCHAR(50),
    genre            ENUM ( 'AUTOBIOGRAPHY', 'BIOGRAPHY', 'CHILDREN_S', 'DRAMA','DYSTOPIAN', 'FANTASY', 'FICTION',
        'HISTORY', 'MYSTERY', 'POETRY', 'RELIGION_AND_SPIRITUALITY', 'ROMANCE', 'SCIENCE_AND_TECHNOLOGY',
        'SCIENCE_FICTION', 'SELF_HELP', 'TRAVEL'),
    ISBN             VARCHAR(10),
    pages_number     integer,
    number_of_copies integer,
    release_date     DATE,
    publisher        VARCHAR(20),
    is_available     boolean DEFAULT true,
    author_id        integer,
    constraint foreign key (author_id) references authors (author_id)

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;


create table if not exists events
(
    event_id     integer primary key auto_increment,
    name         VARCHAR(15),
    date         DATE,
    details      VARCHAR(100)

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;


create table if not exists users
(
    user_id    integer primary key auto_increment,
    first_name    VARCHAR(20),
    last_name     VARCHAR(20),
    address       VARCHAR(50),
    date_of_birth DATE,
    email         VARCHAR(25),
    password      VARCHAR(15),
    role          ENUM('USER', 'ADMIN') DEFAULT 'USER'

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;