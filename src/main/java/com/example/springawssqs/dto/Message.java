package com.example.springawssqs.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Message
{
	String id;
	String content;
	LocalDate createdAt;
}
