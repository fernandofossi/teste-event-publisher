package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestAsyncTransactionalBeforeCommitEvent extends AbstractTestEvent{

	public TestAsyncTransactionalBeforeCommitEvent(Book book) {
		super(book);
		// TODO Auto-generated constructor stub
	}
}
