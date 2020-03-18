package it.polito.tdp.alien.model;

import java.util.*;
import it.polito.tdp.alien.Word;

public class Model {
	
	private LinkedList<Word> lP;
	
	public Model() {
		lP=new LinkedList<Word>();
	}
	
	public boolean addParola(String s1, String s2) {
		Word wTemp=new Word(s1, s2);
		if(this.lP.contains(wTemp))
			return false;
		else {
			this.lP.add(wTemp);
			return true;
		}
	}
	
	public void reset() {
		this.lP.clear();
	}
	
	public String search(String s) {
		for(Word w:lP)
			if(w.getAlienWord().equals(s))
				return "La traduzione della parola cercata è: "+w.getTranslation()+"\n";
		
		return "Parola non trovata\n";
	}
	
	public void update(String s1, String s2) {
		for(Word w:lP)
			if(w.getAlienWord().equals(s1))
				w.setTranslation(s2);
				
	}
	

}
