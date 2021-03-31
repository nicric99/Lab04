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
		final String sql = "SELECT nome,cognome "+
				"FROM studente "+
				"WHERE studente.matricola=? ";
		ArrayList<Studente> studenti= new ArrayList<Studente>();
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
				Studente studente= new Studente(matricola1,nome,cognome,CDS);
				studenti.add(studente);
			}

			conn.close();
			
			return studenti.get(0);
			

		}catch(SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
}
