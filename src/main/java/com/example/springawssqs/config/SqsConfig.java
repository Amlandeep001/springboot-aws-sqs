package com.example.springawssqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class SqsConfig
{
	private final String accessKey;
	private final String secretKey;

	public SqsConfig(@Value("${aws.access.key}") String accessKey, @Value("${aws.secret.key}") String secretKey)
	{
		this.accessKey = accessKey;
		this.secretKey = secretKey;
	}

	@Bean
	AmazonSQS amazonSQSClient()
	{
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonSQSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				// .withEndpointConfiguration(new EndpointConfiguration("https://sqs.ap-south-1.amazonaws.com", "ap-south-1"))
				.withRegion(Regions.AP_SOUTH_1)
				.build();
	}

}
