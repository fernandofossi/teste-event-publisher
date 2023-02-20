package com.fossi.test.eventpublisher.event;

import com.fossi.test.eventpublisher.model.Book;

public class TestSyncTransactionalBeforeCommitEvent extends AbstractTestEvent{

	public TestSyncTransactionalBeforeCommitEvent(Book book) {
		super(book);
		// TODO Auto-generated constructor stub
	}

}
