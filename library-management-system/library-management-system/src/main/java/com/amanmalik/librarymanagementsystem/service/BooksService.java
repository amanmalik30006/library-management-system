package com.amanmalik.librarymanagementsystem.service;

import com.amanmalik.librarymanagementsystem.entity.Book;
import java.util.List;

public interface BooksService {
   public List<Book> getbooks();

  public Book saveBook(Book book);

   public Book getBookByName(String name);


    public Book borrowBook(String bookName);

   public String deleteByBookName(String name);

  public   Book returnBook(String bookName);

   public String checkIfBookIsPresent(String name);
}
