package com.onlineBook.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineBook.store.entity.Books;
import com.onlineBook.store.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepo;
	public void save(Books b) {
		bRepo.save(b);
	}
	public List<Books> getAllBook(){
		return bRepo.findAll();
	}
	public Books getBookById(int id) {
		return bRepo.findById(id).get();
		
	}
}
