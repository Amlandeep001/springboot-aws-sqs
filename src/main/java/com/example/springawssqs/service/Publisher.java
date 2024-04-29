package com.example.springawssqs.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.example.springawssqs.dto.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Publisher
{
	private final String queueName;
	private final AmazonSQS amazonSQSClient;
	private final ObjectMapper objectMapper;

	public Publisher(@Value("${aws.queueName}") String queueName, AmazonSQS amazonSQSClient, ObjectMapper objectMapper)
	{
		this.queueName = queueName;
		this.amazonSQSClient = amazonSQSClient;
		this.objectMapper = objectMapper;
	}

	public void publishMessage(String msg)
	{
		try
		{
			GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);

			var message = Message.builder()
					.id(String.valueOf(new Random().nextInt(900000) + 100000))
					.content(msg)
					.createdAt(LocalDate.now())
					.build();

			var result = amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), objectMapper.writeValueAsString(message));
			log.info("Message sent successfully {}", result);
		}
		catch(Exception e)
		{
			log.error("Queue Exception Message: {}", e.getMessage());
		}
	}

}
