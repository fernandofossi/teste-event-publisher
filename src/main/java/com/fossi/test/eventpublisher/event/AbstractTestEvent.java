package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public abstract class AbstractTestEvent {

	private Book book;

	public AbstractTestEvent(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}
}
