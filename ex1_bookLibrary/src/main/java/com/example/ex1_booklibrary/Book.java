package com.example.ex1_booklibrary;

public class Book {
    private String author;
    private String book_name;
    private  Integer publication_year;
    private  Integer pages;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Book(String author, String book_name, Integer publication_year, Integer pages){
    this.author = author;
    this.book_name  = book_name;
    this.publication_year = publication_year;
    this.pages = pages;
}
}
