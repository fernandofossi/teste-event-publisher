package com.fossi.test.eventpublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fossi.test.eventpublisher.service.TestSyncPublisherService;

@RestController
@RequestMapping("/test/sync")
public class TestSyncController {
	
	@Autowired
	TestSyncPublisherService testSyncPublisherService;

	@GetMapping
	public String testSync() {
		testSyncPublisherService.testSync();
		return "Test Sync Finished";
	}
	
	@GetMapping("/transactional")
	public String testSyncTransactional() {
		testSyncPublisherService.testSyncTransactional();
		return "Test Sync Finished";
	}
	
	@GetMapping("/transactional/after-commit")
	public String testSyncTransactionalAfterCommit() {
		testSyncPublisherService.testSyncTransactionalAfterCommit();
		return "Test Sync Finished";
	}
	
	@GetMapping("/transactional/before-commit")
	public String testSyncTransactionalBeforeCommit() {
		testSyncPublisherService.testSyncTransactionalBeforeCommit();
		return "Test Sync Finished";
	}
	
	@GetMapping("/transactional/after-rollback")
	public String testSyncTransactionalAfterRollback() {
		testSyncPublisherService.testSyncTransactionalAfterRollback();
		return "Test Sync Finished";
	}
}
