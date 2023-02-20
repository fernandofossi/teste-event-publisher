package com.fossi.test.eventpublisher.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.fossi.test.eventpublisher.event.TestSyncEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalAfterCommitEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalAfterRollbackEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalBeforeCommitEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalEvent;
import com.fossi.test.eventpublisher.repository.BookRepository;

@Service
public class TestSyncListenerService extends AbstractTestListenerService {
	
	public TestSyncListenerService(BookRepository bookRepository) {
		super(bookRepository);
		// TODO Auto-generated constructor stub
	}

	@EventListener
	public void testSync(TestSyncEvent event) {
		process(event);
	}
	
	@EventListener
	public void testSyncTransactional(TestSyncTransactionalEvent event) {
		process(event);
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void testSyncTransactionalAfterCommit(TestSyncTransactionalAfterCommitEvent event) {
		process(event);
	}
	
	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void testSyncTransactionalBeforeCommit(TestSyncTransactionalBeforeCommitEvent event) {
		process(event);
	}
	
	@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
	public void testSyncTransactionalAfterRollback(TestSyncTransactionalAfterRollbackEvent event) {
		process(event);
	}
	
}
