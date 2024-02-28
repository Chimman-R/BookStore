package com.onlineBook.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineBook.store.entity.BookList;
import com.onlineBook.store.entity.Books;
import com.onlineBook.store.service.BookListServices;
import com.onlineBook.store.service.BookService;

import ch.qos.logback.core.model.Model;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private BookListServices myBookServices;
	@GetMapping("/")
	public String home() 
	{
		return "Home";
	}
	@GetMapping("/register_now")
	public String registerNow() {
	return "registerNow";
	}
	@GetMapping("/book_shelf")
	public String bookShelf() {
	return "BookShelf";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
	
		List<Books>list = service.getAllBook();
		//ModelAndView m = new ModelAndView();
		//m.setViewName("AvailableBooks");
		//m.addObject("book",list);
		return new ModelAndView("AvailableBooks","book",list);
		
	
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Books b) {
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/services")
	public ModelAndView getAllBooks() 
	{
		List<BookList>list = myBookServices.getAllBooks();
		 //model.addAttribute("book",list);
		return new ModelAndView("services","book",list);
	}
	@GetMapping("/mylist/{id}")
	public String getBookList(@PathVariable("id") int id) {
		Books b = service.getBookById(id);
		BookList bl = new BookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookServices.saveMyBooks(bl);
		return "redirect:/services";
		
	}
	@GetMapping("/editBook/{id}")
	public String editBook() {
		return "edit";
	}
	
	
	
}
