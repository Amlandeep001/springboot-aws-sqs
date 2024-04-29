package com.example.springawssqs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springawssqs.service.Publisher;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SQSDemoController
{
	private final Publisher publisher;

	@GetMapping("/send/{message}")
	public void sendMessageToQueue(@PathVariable String message)
	{
		publisher.publishMessage(message);
	}
}
