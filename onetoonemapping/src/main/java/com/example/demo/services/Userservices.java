package com.example.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.comondto;
@Service
public interface Userservices {

	ResponseEntity<?> add(comondto comondto);

	ResponseEntity<?> get();

	ResponseEntity<?> find(String id);

	ResponseEntity<?> update(comondto comondto);

	ResponseEntity<?> delete(String id);

}
