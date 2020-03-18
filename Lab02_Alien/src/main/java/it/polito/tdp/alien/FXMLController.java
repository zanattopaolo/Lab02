package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtView;

    @FXML
    private Button btnReset;

    @FXML
    void doClear(ActionEvent event) {
    	this.txtView.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String s=this.txtInsert.getText().toLowerCase();
    	
    	/*if((s.equals("")) || (s != null) || !(s.matches("^[a-zA-Z]*$"))) {
    		this.txtView.appendText("Il testo non è stato inserito correttamente\n");
    		return;
    	}*/
    	
    	String a[]=s.split(" ");
    	String back;
    	
    	if(a.length==1) {
    		if(!((!a[0].equals("")) && (a[0] != null) && (a[0].matches("^[a-zA-Z]*$")))) {
        		this.txtView.appendText("Il testo non è stato inserito correttamente\n");
        		this.txtInsert.clear();
        		return;
        	}
    		
    		back = this.model.search(a[0]);
    		this.txtView.appendText(back);
    		this.txtInsert.clear();
    		return;
    	}
    	else {
    		if(!((!a[0].equals("")) && (a[0] != null) && (a[0].matches("^[a-zA-Z]*$"))) || !((!a[1].equals("")) && (a[1] != null) && (a[1].matches("^[a-zA-Z]*$")))) {
        		this.txtView.appendText("Il testo non è stato inserito correttamente\n");
        		this.txtInsert.clear();
        		return;
        	}
    		
    		//aggiornamento parola se è già presente
    		back = this.model.search(a[0]);
    		if(back!="Parola non trovata\n") {
    			this.model.update(a[0], a[1]);
    			this.txtView.appendText("La parola è stata aggiornata");
    			return;
    		}
    		
    		if(this.model.addParola(a[0], a[1]))
    			this.txtView.appendText("La parola è stata aggiunta correttamente al dizionario\n");
    		else
    			this.txtView.appendText("La parola non è stata aggiunta al dizionario\n");
    	}
    	
    	this.txtInsert.clear();
    	return;

    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtView != null : "fx:id=\"txtView\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
    
    
}
