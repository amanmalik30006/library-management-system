package com.amanmalik.librarymanagementsystem.controller;

import com.amanmalik.librarymanagementsystem.entity.Book;
import com.amanmalik.librarymanagementsystem.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BooksService booksservice;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return booksservice.getbooks();
    }
    @GetMapping("/books/{name}")
    public Book getBookByName(@PathVariable String name)
    {
        return booksservice.getBookByName(name);
    }
    @GetMapping("books/borrow/{name}")
    public Book borrowBook( @PathVariable("name") String bookName){
        return  booksservice.borrowBook(bookName);
    }
    @GetMapping("books/return/{name}")
    public Book returnBook( @PathVariable("name") String bookName){
        return  booksservice.returnBook(bookName);
    }
    @GetMapping("/books/check/{name}")
    public String checkIfBookIsPresent(@PathVariable("name") String name){
        return booksservice.checkIfBookIsPresent(name);

    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody  Book book){
        return booksservice.saveBook(book);
    }


    @DeleteMapping("/books/{name}")
    public String deleteByBookName(@PathVariable String name){

        return booksservice.deleteByBookName(name);
    }



}
