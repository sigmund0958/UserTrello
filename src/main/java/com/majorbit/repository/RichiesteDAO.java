package com.majorbit.repository;

import java.util.List;

import com.majorbit.model.Richieste_Fazi;
import com.majorbit.model.User_Trello_Fazi;

public interface RichiesteDAO {
	
	public void create(Richieste_Fazi r);
	public Richieste_Fazi read(Integer id);
	public List<Richieste_Fazi> readMittente(User_Trello_Fazi u);
	public List<Richieste_Fazi> readRicevente(User_Trello_Fazi u);
	public void update(Richieste_Fazi r);
	public void delete(Richieste_Fazi r);

}
