package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestSyncTransactionalAfterCommitEvent extends AbstractTestEvent{

	public TestSyncTransactionalAfterCommitEvent(Book book) {
		super(book);
		// TODO Auto-generated constructor stub
	}

}
