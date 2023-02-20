package com.fossi.test.eventpublisher.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fossi.test.eventpublisher.event.TestSyncEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalAfterCommitEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalAfterRollbackEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalBeforeCommitEvent;
import com.fossi.test.eventpublisher.event.TestSyncTransactionalEvent;
import com.fossi.test.eventpublisher.repository.BookRepository;

@Service
public class TestSyncPublisherService extends AbstractTestPublisherService {

	public TestSyncPublisherService(BookRepository bookRepository,
			ApplicationEventPublisher applicationEventPublisher) {
		super(bookRepository, applicationEventPublisher);
		// TODO Auto-generated constructor stub
	}

	public void testSync() {
		testCommit(TestSyncEvent.class);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void testSyncTransactional() {
		testCommit(TestSyncTransactionalEvent.class);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void testSyncTransactionalAfterCommit() {
		testCommit(TestSyncTransactionalAfterCommitEvent.class);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void testSyncTransactionalBeforeCommit() {
		testCommit(TestSyncTransactionalBeforeCommitEvent.class);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void testSyncTransactionalAfterRollback() {
		testRollback(TestSyncTransactionalAfterRollbackEvent.class);
	}

}
