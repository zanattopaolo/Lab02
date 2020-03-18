package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	public Word(String s1, String s2) {
		this.alienWord=s1;
		this.translation=s2;
	}
		
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getTranslation() {
		return this.translation;
	}
	
	public String getAlienWord() {
		return this.alienWord;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Word) {
			Word w=(Word)o;
			return this.alienWord.equals(w.getAlienWord());
		}
		else
			return false;
	}

}
