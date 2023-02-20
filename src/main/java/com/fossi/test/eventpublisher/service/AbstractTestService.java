package com.fossi.test.eventpublisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fossi.test.eventpublisher.event.AbstractTestEvent;
import com.fossi.test.eventpublisher.model.Book;
import com.fossi.test.eventpublisher.repository.BookRepository;

public abstract class AbstractTestService {
	
	protected final Logger logger;
	protected final BookRepository bookRepository;
	
	public AbstractTestService(BookRepository bookRepository) {
		this.logger = LoggerFactory.getLogger(getClass());
		this.bookRepository = bookRepository;
	}
	
	protected void fakeProcessing() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void process(AbstractTestEvent event) {
		this.logger.info("Received event {}", event);
		fakeProcessing();
		changeBookName(event.getBook());
		this.logger.info("Finished event processing");
	}
	
	protected void changeBookName(Book book) {
		String bookname = book.getNome();
		book.setNome(bookname.concat(" Changed by Listener"));
		bookRepository.saveAndFlush(book);
	}

}
