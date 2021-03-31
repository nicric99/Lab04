package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getDatiStudente(Integer matricola){
		final String sql = "SELECT nome,cognome,matricola,CDS "+
				"FROM studente "+
				"WHERE studente.matricola=? ";
		// inizializzazione è necessaria
		Studente studente=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola1 = rs.getInt("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String CDS = rs.getString("CDS");

//				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Aggiungi il nuovo oggetto Corso alla lista corsi
				 studente= new Studente(matricola1,nome,cognome,CDS);
//				studenti.add(studente);
			}

			conn.close();
			return studente;
//			return studenti.get(0);
			

		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public boolean cercaStudente(Integer matricola) {
		final String sql = "SELECT matricola "+
				"FROM studente "+
				"WHERE studente.matricola=? ";
		// inizializzazione è necessaria
		Studente studente=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()==false) {
				return false;
			}else {
				return true;
			}

		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}	
	}
	public boolean studenteIscritto(Integer matricola, String corso) {
		final String sql="SELECT iscrizione.matricola,corso.nome "+
				"FROM iscrizione,corso "+
				"WHERE corso.nome=? AND iscrizione.matricola=? AND corso.codins=iscrizione.codins ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso);
			st.setInt(2, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()==false) {
				return false;
			}else {
				return true;
			}

		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}	
		
		
		
	}
	
}
