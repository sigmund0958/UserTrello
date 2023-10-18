package com.majorbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majorbit.model.Richieste_Fazi;
import com.majorbit.model.User_Trello_Fazi;
import com.majorbit.repository.RichiesteDAO;
import com.majorbit.repository.UserDAO;

@RestController
@CrossOrigin("*")
public class RichiesteController {

	@Autowired
	private RichiesteDAO dao;
	@Autowired
	private UserDAO daoUser;
	
	@GetMapping("/readId")
	public Object read(@RequestParam Integer id) {
		Richieste_Fazi check= dao.read(id);
		if(check!=null) {
			return check;
		}else {
			return "La richiesta inserita non esiste";
		}
	}
	@GetMapping("/readSending")
	public Object readSending(@RequestParam String email) {
		User_Trello_Fazi check= daoUser.read(email);
		if(check!=null) {
			List<Richieste_Fazi> list= dao.readMittente(check);
			if(!list.isEmpty()) {
				return list;
			}else {
				return "Non ci sono richieste inviate da questo utente";
			}			
		}else {
			return "Non esist l'utente inserito";
		}
	}
	@GetMapping("/readReceiving")
	public Object readReceiving(@RequestParam String email) {
		User_Trello_Fazi check= daoUser.read(email);
		if(check!=null) {
			List<Richieste_Fazi> list= dao.readRicevente(check);
			if(!list.isEmpty()) {
				return list;
			}else {
				return "Non ci sono richieste ricevute da questo utente";
			}			
		}else {
			return "Non esist l'utente inserito";
		}
	}
	
	@PostMapping("/createRichiesta")
	public String create(@RequestBody Richieste_Fazi r) {
			User_Trello_Fazi mitt= daoUser.read(r.getSendingUser().getEmail());
			if(mitt!=null) {
				User_Trello_Fazi rec= daoUser.read(r.getReceivingUser().getEmail());
				if(rec!=null) {
					boolean flag= statusCheck(r.getStatus());
					if(flag) {
						dao.create(r);
						return "Richiesta inviata";
					}else {
						return "Lo status deve essere 'accaettata', 'rifiutata' o 'in attesa'";
					}					
				}else {
					return "L'user ricevente non esiste";
				}
			}else {
				return "L'user mittente non esiste";
			}			
	}
	@PutMapping("/updateRichiesta")
	public String update(@RequestBody Richieste_Fazi r) {
		Richieste_Fazi check= dao.read(r.getId());
		if(check!=null) {
			User_Trello_Fazi mitt= daoUser.read(r.getSendingUser().getEmail());
			if(mitt!=null) {
				User_Trello_Fazi rec= daoUser.read(r.getReceivingUser().getEmail());
				if(rec!=null) {
					boolean flag= statusCheck(r.getStatus());
					if(flag) {
						dao.update(r);
						return "Richiesta modificata";
					}else {
						return "Lo status deve essere 'accaettata', 'rifiutata' o 'in attesa'";
					}
				}else {
					return "L'user ricevente non esiste";
				}
			}else {
				return "L'user mittente non esiste";
			}		
		}else {
			return "La richiesta inserita non esiste";
		}
	}
	@DeleteMapping("/deleteRichiesta/{id}")
	public String delete(@PathVariable Integer id) {
		Richieste_Fazi check= dao.read(id);
		if(check!=null) {
			dao.delete(check);
			return "Richiesta eliminata";
		}else {
			return "La richiesta inserita non esiste";
		}
	}
	
	private boolean statusCheck(String status) {
		boolean flag= false;
		if(status.equals("accettata") || status.equals("rifiutata")|| status.equals("in attesa")) {
			flag=true;
		}
		return flag;
	}
}
