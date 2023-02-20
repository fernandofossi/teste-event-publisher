package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestAsyncTransactionalAfterRollbackEvent extends AbstractTestEvent{

	public TestAsyncTransactionalAfterRollbackEvent(Book book) {
		super(book);
	}

}
