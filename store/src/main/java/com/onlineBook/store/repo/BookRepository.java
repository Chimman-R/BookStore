package com.onlineBook.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineBook.store.entity.Books;
@Repository
public interface BookRepository extends JpaRepository<Books,Integer>{

}
