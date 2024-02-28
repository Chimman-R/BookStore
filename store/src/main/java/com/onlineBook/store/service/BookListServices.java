package com.onlineBook.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineBook.store.entity.BookList;
import com.onlineBook.store.repo.BookRepo;

@Service
public class BookListServices {
	@Autowired
	private BookRepo book;
	public void saveMyBooks(BookList books) {
		book.save(books);
	}
	public List<BookList> getAllBooks() {
		return book.findAll();
	}
	public void deleteById(int id) {
		book.deleteById(id);
	}
}
