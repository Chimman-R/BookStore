package com.onlineBook.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineBook.store.service.BookListServices;

@Controller
public class BookListController {
	
	@Autowired
	private BookListServices service;
	
	 
	@GetMapping("/deleteList/{id}")
	public String deleteList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/services";
	}
}
