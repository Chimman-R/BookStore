package com.onlineBook.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineBook.store.entity.BookList;
@Repository
public interface BookRepo extends JpaRepository<BookList,Integer> {

}
