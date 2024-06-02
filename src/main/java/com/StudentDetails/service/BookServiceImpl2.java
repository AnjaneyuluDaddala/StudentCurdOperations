package com.StudentDetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.StudentDetails.Entity.Book;

import studentexceptionHandler.BookNotFoundException;
import studentexceptionHandler.IdNotFoundException;

@Service
public class BookServiceImpl2 implements BookService{

	@Override
	public void addBook(Book book) {
		System.out.println(book);
		
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		 List<Book> collect = getBookList().stream().filter(book->book.getAuthor().equals(author)).collect(Collectors.toList());
		 if(collect.isEmpty()) {
			 throw new BookNotFoundException("Book with author not found");
		 }else {
			 return collect;
		 }
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		 List<Book> collect = getBookList().stream().filter(book->book.getAuthor().equals(category)).collect(Collectors.toList());
		 if(collect.isEmpty()) {
			 throw new BookNotFoundException("Book with category not found");
		 }else {
			 return collect;
		 }
	}

	@Override
	public Book getBookById(int id) {
		
		/*
		 *  Optional<Book> findAny = getBookList().stream().filter(book->book.getBookid()==id).findAny();
		 *   if(findAny.isPresent()) {
			 return findAny.get();
		    }else {
			 throw new IdNotFoundException("Invalid id ");
		    }
		 */
		
		 
		 //or 
		if(id<=0) {
			throw new RuntimeException("other type of exceptions.");
		}
		return getBookList().stream().filter(book->book.getBookid()==id).findAny().orElseThrow(()->new IdNotFoundException("Invalid id"));
		 
	}
	
	public List<Book> getBookList(){
		Book b1=new Book("Java","anjan","Tech",12);
		Book b2=new Book("Python","prasanna","Non-IT",10);
		Book b3=new Book("reactjs","lokesh","IT",11);
		Book b4=new Book("c++","sowmya","Tech",10);
		
		List<Book>book=new ArrayList<>();
		book.add(b1);
		book.add(b2);
		book.add(b3);
		book.add(b4);
		return book;
	}
	

	
	
	

}
