package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.comondto;
import com.example.demo.model.User;
import com.example.demo.services.Userservices;
import com.example.demo.servicesImp.UserServiceImp;

@RestController
public class UserController {

	@Autowired
	Userservices userService;

	@PostMapping("/map")
	public ResponseEntity<?> add(@RequestBody comondto comondto) {
		return userService.add(comondto);
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> get() {
		return userService.get();
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findbyid(@PathVariable(name = "id") String id) {
		return userService.find(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody comondto comondto){
		return userService.update(comondto);
	}
	
	@DeleteMapping("/delet/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id")String id){
		return userService.delete(id);
	}

}
