package com.amanmalik.librarymanagementsystem.repository;

import com.amanmalik.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book,Long> {
    public Book findByBookName(String name);
    public long deleteByBookName(String bookName);


}
