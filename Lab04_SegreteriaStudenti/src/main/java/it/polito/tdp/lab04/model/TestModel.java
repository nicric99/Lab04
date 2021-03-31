package it.polito.tdp.lab04.model;
import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
public class TestModel {

	public static void main(String[] args) {

		Model model= new Model();
//		ArrayList<String> corsi= new ArrayList<String>();
		for(Corso c: model.getTuttiICorsi()) {
		System.out.println(c.getNome());
		}
//		System.out.println(ciao.toString());
	}

}
