package com.vehiclerentalsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehiclerentalsystem.entity.User;
import com.vehiclerentalsystem.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/user/all")
	public List<User> fetchAllUsers(){
		List<User> userLsit=userService.getAllusers();
		return userLsit;
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> fetchUserDetails(@PathVariable("userId") int userId){
		User user=userService.getUserById(userId);
		ResponseEntity<User>responseEntity=new ResponseEntity<>(user,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user){
		User updateUser=userService.updateUser(user);
		ResponseEntity<User> responseEntity=new ResponseEntity<>(updateUser, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public ResponseEntity<String> removeUser(@PathVariable("userId")int userId){
		userService.deleteUser(userId);
		ResponseEntity<String> responseEntity=new ResponseEntity<>("User deleted successfully!!",HttpStatus.OK);
		return responseEntity;
	}

}
