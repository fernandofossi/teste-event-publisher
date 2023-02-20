package com.fossi.test.eventpublisher.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.context.ApplicationEventPublisher;

import com.fossi.test.eventpublisher.event.AbstractTestEvent;
import com.fossi.test.eventpublisher.model.Book;
import com.fossi.test.eventpublisher.repository.BookRepository;

public abstract class AbstractTestPublisherService extends AbstractTestService {

	private final ApplicationEventPublisher applicationEventPublisher;

	public AbstractTestPublisherService(BookRepository bookRepository,
			ApplicationEventPublisher applicationEventPublisher) {
		super(bookRepository);
		this.applicationEventPublisher = applicationEventPublisher;
	}

	protected <T extends AbstractTestEvent> void testCommit(Class<T> eventClass) {
		testEvent(eventClass);
		this.logger.info("Finished");
	}

	protected <T extends AbstractTestEvent> void testRollback(Class<T> eventClass) {
		testEvent(eventClass);
		throw new RuntimeException();
	}

	protected <T extends AbstractTestEvent> void testEvent(Class<T> eventClass) {
		Book book = createBook();
		sendEvent(eventClass, book);

		this.logger.info("Publisher Processing");
		fakeProcessing();

		changeBookName(book);

		this.logger.info("Finished");
	}

	protected <T extends AbstractTestEvent> void sendEvent(Class<T> eventClass, Book book) {
		this.logger.info("Sending event");
		try {
			applicationEventPublisher.publishEvent(eventClass.getDeclaredConstructor(Book.class).newInstance(book));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Book createBook() {
		this.logger.info("Creating register on database");
		Book book = new Book();
		book.setNome("teste");
		bookRepository.save(book);
		return book;
	}

	protected void changeBookName(Book book) {
		this.logger.info("Changing bookname");
		book.setNome(book.getNome().concat(" Changed by publisher"));
		bookRepository.save(book);
	}

}
