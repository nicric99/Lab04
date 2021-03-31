package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

//				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Aggiungi il nuovo oggetto Corso alla lista corsi
				Corso tmp= new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(tmp);
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
/*public Corso getCorso(String corso) {
		final String sql ="SELECT c.codins,c.crediti,c.nome,c.pd "+
		"FROM corso AS c "+
		"WHERE c.nome=? ";

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, corso);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins  = rs.getString("codins");
				Integer crediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				Integer pd = rs.getInt("pd");

//				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Aggiungi il nuovo oggetto Corso alla lista corsi
				Corso c1;
				c1= new Corso(codins,crediti,nome,pd);
				conn.close();		
				
				
			}
			//return c1;
	
			
	}catch(SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
		}
	}*/

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(String corso) {
		
		final String sql = "SELECT s.matricola,s.cognome,s.nome,s.CDS "+
				"FROM studente AS s,iscrizione,corso "+
				"WHERE s.matricola=iscrizione.matricola AND corso.codins=iscrizione.codins AND corso.nome=? ";
		

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			

			st.setString(1, corso);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola = rs.getInt("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String CDS = rs.getString("CDS");

//				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Aggiungi il nuovo oggetto Corso alla lista corsi
				Studente tmp= new Studente(matricola,nome,cognome,CDS);
				studenti.add(tmp);
			}

			conn.close();
			
			return studenti;
			
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
