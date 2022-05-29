package com.vehiclerentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclerentalsystem.entity.User;
import com.vehiclerentalsystem.exception.AuthenticationFailedException;
import com.vehiclerentalsystem.exception.UserNotFoundException;
import com.vehiclerentalsystem.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public List<User> getAllusers() {
		List<User>allUsers=userRepository.findAll();
		return allUsers;
	}
	
	@Override
	public User getUserById(int userId) {
		Optional<User>optionalUser=userRepository.findById(userId);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:"+userId);
		}
		User user=optionalUser.get();
		return user;
	}

	@Override
	public User updateUser(User user) {
		Optional<User>optionalUser=userRepository.findById(user.getUserId());
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:"+user.getUserId());
		}
		User updateUser=optionalUser.get();
		return updateUser;
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User>optionalUser=userRepository.findById(userId);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not existing with Id:"+userId);
		}
		userRepository.deleteById(userId);
		
	}


	@Override
	public User doLogin(String email, String password){
		
		User user=userRepository.login(email,password);
		if(user==null) {
			throw new AuthenticationFailedException("Username or password Invalid!!");
		}
		return user;
	}
	
}
