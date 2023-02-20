package com.fossi.test.eventpublisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossi.test.eventpublisher.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
