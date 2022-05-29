package com.vehiclerentalsystem.service;

import java.util.List;

import com.vehiclerentalsystem.entity.User;

public interface UserService {
	public List<User> getAllusers();
	public User getUserById(int userId);
	public User updateUser(User user);
	public void deleteUser(int userId);
	public User doLogin(String email,String password);
    
}
