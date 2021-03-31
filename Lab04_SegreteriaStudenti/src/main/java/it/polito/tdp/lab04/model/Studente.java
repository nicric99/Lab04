package it.polito.tdp.lab04.model;

public class Studente {
	@Override
	public String toString() {
		return " [Matricola=" + Matricola + ", Nome=" + Nome + ", cognome=" + cognome + ", CDS=" + CDS + "]";
	}


	private Integer Matricola;
	private String Nome;
	private String cognome;
	private String CDS;
	public Studente(Integer matricola, String nome, String cognome, String cDS) {
		super();
		Matricola = matricola;
		Nome = nome;
		this.cognome = cognome;
		CDS = cDS;
	}
	public Integer getMatricola() {
		return Matricola;
	}
	public void setMatricola(Integer matricola) {
		Matricola = matricola;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCDS() {
		return CDS;
	}
	public void setCDS(String cDS) {
		CDS = cDS;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CDS == null) ? 0 : CDS.hashCode());
		result = prime * result + ((Matricola == null) ? 0 : Matricola.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		return result;
	}

	
	public boolean equals(Studente obj) {
		if(obj.getMatricola()==this.getMatricola()) {
			return true;
		}else {
			return false;
		}
	}
	
}
