package com.example.demo.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.comondto;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repo.AddressRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.Userservices;

@Service
public class UserServiceImp implements Userservices {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	Environment environment;

	@Override
	public ResponseEntity<?> add(comondto comondto) {
		try {

			Address address = Address.builder().city(comondto.getCity()).doorNo(comondto.getDoorNo())
					.pin(comondto.getPin()).build();
			addressRepo.save(address);
			User user = User.builder().name(comondto.getName()).address(address).build();
			userRepo.save(user);
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.OK.value(), environment.getProperty("success"), user));
		} catch (Exception e) {
			return ResponseEntity
					.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), environment.getProperty("failed")));
		}

	}

	@Override
	public ResponseEntity<?> get() {
		List<User> out = userRepo.findAll();
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), environment.getProperty("success"), out));
	}

	@Override
	public ResponseEntity<?> find(String id) {
		User out = userRepo.findById(id).get();
		UserDto user1 = UserDto.builder().id(id).name(out.getName()).address(out.getAddress()).build();
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), environment.getProperty("success"), user1));
	}

	@Override
	public ResponseEntity<?> update(comondto comondto) {
		User optional = userRepo.findById(comondto.getId()).get();
		Address optional1 =addressRepo.findById(comondto.getAddresid()).get();
		Address address = Address.builder().id(optional1.getId()).city(comondto.getCity()).doorNo(comondto.getDoorNo()).pin(comondto.getPin())
				.build();
		addressRepo.save(address);
		User user1 = User.builder().id(optional.getId()).name(comondto.getName()).address(address).build();
		userRepo.save(user1);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), environment.getProperty("success"), user1));
	}

	@Override
	public ResponseEntity<?> delete(String id) {
		userRepo.deleteById(id);
		return ResponseEntity
				.ok(new MessageResponse(HttpStatus.OK.value(), environment.getProperty("success.Delete"), null));
	}

}
