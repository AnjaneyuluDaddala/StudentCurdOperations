package com.StudentDetails.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentDetails.Entity.Book;
import com.StudentDetails.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookserv;
	
	
	//Testing working or not
	@GetMapping("/greet")
	public ResponseEntity<String>sayHello(){
		String msg="welcome to book app";
		HttpHeaders header=new HttpHeaders();
		header.add("desc","Online book application");
		return new ResponseEntity<String>(msg,header,HttpStatus.OK);
	}
	
	//save the book (no return type)
	@PostMapping("/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book){
		this.bookserv.addBook(book);
		HttpHeaders header=new HttpHeaders();
		header.add("desc","Adding one Book");
		return ResponseEntity.status(HttpStatus.OK).headers(header).build();
	}
	
	//getting bookByid
	@GetMapping("/books/{id}")
	public ResponseEntity<Book>getBookById(@PathVariable("id") int bookid){
		Book bookById = this.bookserv.getBookById(bookid);
		HttpHeaders hp=new HttpHeaders();
		hp.add("desc","getBook by id !");
		return ResponseEntity.status(HttpStatus.OK).headers(hp).body(bookById);
		
	}
	
	//getting bookbyAuthor
	@GetMapping("/book-by-author/{author}")
	public ResponseEntity<List<Book>>getBookByAuthor(@PathVariable String author){
		List<Book> bookByAuthor = this.bookserv.getBookByAuthor(author);
		return ResponseEntity.ok(bookByAuthor);
		
	}
	
	//getting bookbyCategory
	@GetMapping("book-by-category")
	public ResponseEntity<List<Book>>getBookByCategory(@RequestParam("category") String category){
		List<Book> bookByCategory = this.bookserv.getBookByCategory(category);
		HttpHeaders hp=new HttpHeaders();
		hp.add("desc", "List of books by category");
		hp.add("byType","Book obj");
		return ResponseEntity.status(HttpStatus.OK).headers(hp).body(bookByCategory);
		
	}

	

}
