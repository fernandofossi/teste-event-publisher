package com.fossi.test.eventpublisher.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fossi.test.eventpublisher.event.TestAsyncEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalAfterCommitEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalAfterRollbackEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalBeforeCommitEvent;
import com.fossi.test.eventpublisher.event.TestAsyncTransactionalEvent;
import com.fossi.test.eventpublisher.repository.BookRepository;

@Service
public class TestAsyncPublisherService extends AbstractTestPublisherService {

	public TestAsyncPublisherService(BookRepository bookRepository,
			ApplicationEventPublisher applicationEventPublisher) {
		super(bookRepository, applicationEventPublisher);
		// TODO Auto-generated constructor stub
	}

	public void testAsync() {
		testCommit(TestAsyncEvent.class);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void testAsyncTransactional() {
		testCommit(TestAsyncTransactionalEvent.class);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void testAsyncTransactionalAfterCommit() {
		testCommit(TestAsyncTransactionalAfterCommitEvent.class);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void testAsyncTransactionalBeforeCommit() {
		testCommit(TestAsyncTransactionalBeforeCommitEvent.class);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void testAsyncTransactionalAfterRollback() {
		testRollback(TestAsyncTransactionalAfterRollbackEvent.class);
	}
}
