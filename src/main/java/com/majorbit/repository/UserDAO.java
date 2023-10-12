package com.majorbit.repository;

import com.majorbit.model.User_Trello_Fazi;

public interface UserDAO {
	
	public void create(User_Trello_Fazi u);
	public User_Trello_Fazi read(String email);
	public void update(User_Trello_Fazi u);
	public void delete(User_Trello_Fazi u);

}
