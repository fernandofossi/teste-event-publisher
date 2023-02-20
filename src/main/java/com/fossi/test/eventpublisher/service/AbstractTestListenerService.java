package com.fossi.test.eventpublisher.service;

import com.fossi.test.eventpublisher.event.AbstractTestEvent;
import com.fossi.test.eventpublisher.model.Book;
import com.fossi.test.eventpublisher.repository.BookRepository;

public abstract class AbstractTestListenerService extends AbstractTestService {
	
	public AbstractTestListenerService(BookRepository bookRepository) {
		super(bookRepository);
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
