package com.StudentDetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.StudentDetails.Entity.Book;

@Service
@Primary
public class BookServiceImpl implements BookService{

	@Override
	public void addBook(Book book) {
		System.out.println(book);
		
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		return getBookList().stream().filter(book->book.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		return getBookList().stream().filter(book->book.getAuthor().equals(category)).collect(Collectors.toList());
	}

	@Override
	public Book getBookById(int id) {
		
		return getBookList().stream().filter(book->book.getBookid()==id).findAny().orElse(new Book());
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
