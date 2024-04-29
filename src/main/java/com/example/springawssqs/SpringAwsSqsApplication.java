package com.example.springawssqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringAwsSqsApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringAwsSqsApplication.class, args);
	}

	/*@Bean
	ApplicationRunner runner(Publisher publisher)
	{
		return args ->
		{
			Thread.sleep(3000);
			for(int i = 0; i < 10; i++)
			{
				publisher.publishMessage(String.valueOf(i));
			}
		};
	}*/

}
