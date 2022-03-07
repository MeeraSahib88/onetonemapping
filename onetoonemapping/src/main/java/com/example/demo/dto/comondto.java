package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class comondto {
	
	private String id;
	
	private String addresid;
	
	private String name;
	
	private String doorNo;

	private String city;

	private int pin;
}
