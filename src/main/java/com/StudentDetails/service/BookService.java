package com.StudentDetails.service;

import java.util.List;

import com.StudentDetails.Entity.Book;

public interface BookService {
	 void addBook(Book book);
	 List<Book>getBookByAuthor(String author);
	 List<Book>getBookByCategory(String category);
	 Book getBookById(int id);
	
	

}
