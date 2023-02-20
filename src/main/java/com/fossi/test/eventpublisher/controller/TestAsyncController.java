package com.fossi.test.eventpublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fossi.test.eventpublisher.service.TestAsyncPublisherService;

@RestController
@RequestMapping("/test/async")
public class TestAsyncController {
	
	@Autowired
	TestAsyncPublisherService testAsyncPublisherService;

	@GetMapping
	public String testAsync() {
		testAsyncPublisherService.testAsync();
		return "Test Async Finished";
	}
	
	@GetMapping("/transactional")
	public String testAsyncTransactional() {
		testAsyncPublisherService.testAsyncTransactional();
		return "Test Async Finished";
	}
	
	@GetMapping("/transactional/after-commit")
	public String testAsyncTransactionalAfterCommit() {
		testAsyncPublisherService.testAsyncTransactionalAfterCommit();
		return "Test Async Finished";
	}
	
	@GetMapping("/transactional/before-commit")
	public String testAsyncBeforeCommit() {
		testAsyncPublisherService.testAsyncTransactionalBeforeCommit();
		return "Test Async Finished";
	}
	
	@GetMapping("/transactional/after-rollback")
	public String testAsyncTransactionalAfterRollback() {
		testAsyncPublisherService.testAsyncTransactionalAfterRollback();
		return "Test Async Finished";
	}
}
