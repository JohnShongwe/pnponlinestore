package main.service;

import main.model.User;

public interface UserService {
	//saveAdmin
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void saveAdmin(User user);
	public void saveDriver(User user);
	public void saveSupplier(User user);
	
}
