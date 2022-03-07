package com.example.demo.dto;

import com.example.demo.model.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@NoArgsConstructor
@AllArgsConstructor@Builder
public class UserDto {

	private String id;

	private String name;

	private Address address;

}
