package com.amanmalik.librarymanagementsystem.service;

import com.amanmalik.librarymanagementsystem.entity.Book;
import com.amanmalik.librarymanagementsystem.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksrepository;
    @Override
    public List<Book> getbooks() {
        return booksrepository.findAll();
    }
    @Override
    public Book saveBook(Book book){
        return booksrepository.save(book);
    }

    @Override
    public Book getBookByName(String name) {
        return booksrepository.findByBookName(name);
    }

    @Override
    public Book borrowBook(String bookName) {
       Book nBook=booksrepository.findByBookName(bookName);

       nBook.setNoOfBooks(nBook.getNoOfBooks()-1);
       booksrepository.save(nBook);
       return nBook;

    }

    @Override
    public String deleteByBookName(String name) {
        Book book=booksrepository.findByBookName(name);

        booksrepository.deleteById(book.getBookId());
        return "book deleted successfully";
    }

    @Override
    public Book returnBook(String bookName) {
        Book nBook=booksrepository.findByBookName(bookName);
//        booksrepository.deleteById(nBook.getBookId());
        nBook.setNoOfBooks(nBook.getNoOfBooks()+1);
        booksrepository.save(nBook);
        return nBook;
    }

    @Override
    public String checkIfBookIsPresent(String name) {
        Book book=booksrepository.findByBookName(name);
        if(Objects.nonNull(book))
            return "book is present";
        else return "book is not present";
    }


}
