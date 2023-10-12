package com.majorbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majorbit.model.User_Trello_Fazi;
import com.majorbit.repository.UserDAO;

@RestController
public class UserController {

	@Autowired 
	private UserDAO dao;
	
	@GetMapping("/read")
	public Object read(@RequestParam String email) {
		User_Trello_Fazi check= dao.read(email);
		if(check!=null) {
			return check;
		}else {
			return "L'utente cercato non esiste";
		}
	}
	@PostMapping("/create")
	public String create(@RequestBody User_Trello_Fazi u) {
		String email= u.getEmail();
		User_Trello_Fazi check= dao.read(email);
		if(check==null) {
			dao.create(u);
			return "Utente creato";
		}else {
			return "L'utente esiste gia'";
		}
	}
	@PutMapping ("/update")
	public String update(@RequestBody User_Trello_Fazi u) {
		String email= u.getEmail();
		User_Trello_Fazi check= dao.read(email);
		if(check!=null) {
			dao.update(u);
			return "Utente modificato";
		}else {
			return "L'utente non esiste";
		}
	}
	@DeleteMapping("/delete/{email}")
	public String delete(@PathVariable String email) {
		User_Trello_Fazi check= dao.read(email);
		if(check!=null) {
			dao.delete(check);
			return "Utente eliminato";
		}else {
			return "L'utente non esiste";
		}
	}
}
