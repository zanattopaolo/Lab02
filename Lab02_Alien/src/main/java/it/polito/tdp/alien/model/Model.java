package it.polito.tdp.alien.model;

import java.util.*;
import it.polito.tdp.alien.WordEnhanced;

public class Model {
	
	private LinkedList<WordEnhanced> lP;
	
	public Model() {
		lP=new LinkedList<WordEnhanced>();
	}
	
	public boolean addParola(String s1, String s2) {
		WordEnhanced wTemp=new WordEnhanced(s1, s2);
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
		for(WordEnhanced w:lP)
			if(w.getAlienWord().equals(s))
				return "La/le traduzione/i della parola cercata è/sono: "+w.getTranslation()+"\n";
		
		return "Parola non trovata\n";
	}
	
	public void update(String s1, String s2) {
		for(WordEnhanced w:lP)
			if(w.getAlienWord().equals(s1))
				w.addTranslation(s2);
				
	}
	

}
