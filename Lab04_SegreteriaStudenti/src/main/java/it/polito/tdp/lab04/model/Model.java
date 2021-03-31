package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.*;
public class Model {
	
	private CorsoDAO CorsoDAO;
	private StudenteDAO StudenteDAO;
	public Model() {
		CorsoDAO= new CorsoDAO();
		StudenteDAO= new StudenteDAO();
//		it.polito.tdp.lab04.DAO.StudenteDAO= new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		
		return CorsoDAO.getTuttiICorsi();
	}
	public List<Studente> getStudentiIscrittiAlCorso(String corso){
		//CorsoDAO.getCorso(corso);
		return CorsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	public Studente getDatiStudente(Integer matricola) {
		//return StudenteDAO.getDatiStudente(matricola); 
		return StudenteDAO.getDatiStudente(matricola);
	}
	public LinkedList<Corso> getCorsiDatoStudente(Integer matricola){
		boolean trovato;
		trovato= StudenteDAO.cercaStudente(matricola);
		if(!trovato) {
			return null;
			
		}else{
			return CorsoDAO.getCorsiDatoStudente(matricola);
			
		}
	}
}
