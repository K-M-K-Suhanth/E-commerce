package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
	public boolean adduser(User user);
	public boolean updateuser(User user);
	public boolean deleteuser(User user);
	public User getuser(String username);
	public User getrole(String role);
	public User getpassword(String password);
	public List<User> listusers();
	public User validate(String username, String password);
}
