package com.fossi.test.eventpublisher.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.fossi.test.eventpublisher.event.TestAsyncEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalAfterCommitEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalAfterRollbackEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalBeforeCommitEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalEvent;
import com.fossi.test.eventpublisher.repository.BookRepository;

@Service
public class TestAsyncListenerService extends AbstractTestService {

	public TestAsyncListenerService(BookRepository bookRepository) {
		super(bookRepository);
		// TODO Auto-generated constructor stub
	}

	@EventListener
	@Async
	public void testAsync(TestAsyncEvent event) {
		process(event);
	}
	
	@EventListener
	@Async
	public void testAsyncTransactional(TestAsyncTransactionalEvent event) {
		process(event);
	}

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	@Async
	public void testAsyncTransactionalAfterCommit(TestAsyncTransactionalAfterCommitEvent event) {
		process(event);
	}
	
	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	@Async
	public void testAsyncTransactionalBeforeCommit(TestAsyncTransactionalBeforeCommitEvent event) {
		process(event);
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	@Async
	public void testAsyncTransactionalAfterRollback(TestAsyncTransactionalAfterRollbackEvent event) {
		process(event);
	}
	
}
