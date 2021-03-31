/**
 * Sample Skeleton for 'Scene.fxml' Controller Classp
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	ObservableList<String> list= FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> wdwCorso;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	Integer matricola;
    	LinkedList<Corso> corsi= new LinkedList<Corso>();
    	
    	try {
        	matricola= Integer.parseInt(txtCodice.getText());
        	corsi= model.getCorsiDatoStudente(matricola);
        	System.out.println("Errore con il codice ");
    		if(corsi.isEmpty()) {
        		txtResult.setText(" Attenzione studente non esistente ");
        	}else {
        		for(Corso c:corsi) {
        			txtResult.appendText(c.toString());
        			txtResult.appendText("\n");
        		}
        	}}catch(NumberFormatException nfe) {
        		txtResult.appendText("Errore nel codice");
            }catch(NullPointerException npe) {
        		txtResult.appendText(" Attenzione il codice dell'utente è inesistente");
        	}
    	// supponiamo uno studente abbia almeno un corso a cui partecipa

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	String corso=wdwCorso.getValue();
    	LinkedList<Studente> studenti= new LinkedList<Studente>();
    	// ipotizziamo che i nomi dei corsi non siano uguali con codici diversi
    	if( corso==" ") {
    		txtResult.appendText(" Attenzione nessun corso selezionato");
    		return;
    	}
    	studenti=(LinkedList<Studente>) model.getStudentiIscrittiAlCorso(corso);
    	for(Studente s:studenti) {
    		txtResult.appendText(s.toString());
    		txtResult.appendText("\n");
    	}
    	
    	
    }

    @FXML
    void doComplete(ActionEvent event) {
    	Integer matricola;
    	try {
    	matricola= Integer.parseInt(txtCodice.getText());
    	Studente s= model.getDatiStudente(matricola);
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	}catch(NumberFormatException nfe) {
    		System.out.println("Errore con il codice ");
    	}catch(NullPointerException npe) {
    		txtResult.setText("Attenzione ,utente non esistente");
    	}
    }

    @FXML
    void doIscriviStudente(ActionEvent event) {

    }

  public void loadData() {
    	list.removeAll();
//    	System.out.println(model.getTuttiICorsi());
    	

    for(Corso c:model.getTuttiICorsi()) {
    		list.add(c.getNome());
    	}
    list.add(" ");
    wdwCorso.getItems().addAll(list);
       
    }
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtCodice.clear();
    	txtNome.clear();
    	txtCognome.clear();

    }
    public void setModel(Model model) {
    	this.model=model; 
    	loadData();    
    }

    @FXML
    void initialize() {
        assert wdwCorso != null : "fx:id=\"wdwCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}