package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestSyncTransactionalAfterRollbackEvent extends AbstractTestEvent{

	public TestSyncTransactionalAfterRollbackEvent(Book book) {
		super(book);
		// TODO Auto-generated constructor stub
	}

}
