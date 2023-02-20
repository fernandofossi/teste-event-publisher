package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestAsyncTransactionalAfterCommitEvent extends AbstractTestEvent{

	public TestAsyncTransactionalAfterCommitEvent(Book book) {
		super(book);
	}

}
