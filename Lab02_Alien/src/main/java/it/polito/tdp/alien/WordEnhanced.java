package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private LinkedList<String> translation;
	
	public WordEnhanced(String s1, String s2) {
		this.alienWord=s1;
		this.translation=new LinkedList<String>();
		this.translation.add(s2);
	}
		
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	/*public Collection<String> getTranslation() {
		return this.translation;
	}*/
	
	public String getAlienWord() {
		return this.alienWord;
	}
	
	public String getTranslation() {
		String s1="";
		for(String s:this.translation)
			s1=s1+", "+s;
		
		s1=s1.substring(2);
		return s1;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof WordEnhanced) {
			WordEnhanced w=(WordEnhanced)o;
			return this.alienWord.equals(w.getAlienWord());
		}
		else
			return false;
	}
	
	public void addTranslation(String s) {
		this.translation.add(s);
	}

}
