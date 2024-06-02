package com.StudentDetails.service;

import java.util.List;

import com.StudentDetails.Entity.Book;

import studentexceptionHandler.BookNotFoundException;
import studentexceptionHandler.IdNotFoundException;

public interface BookService2 {
	 void addBook(Book book);
	 List<Book>getBookByAuthor(String author)throws BookNotFoundException;
	 List<Book>getBookByCategory(String category)throws BookNotFoundException;
	 Book getBookById(int id)throws IdNotFoundException ;
	
	

}
