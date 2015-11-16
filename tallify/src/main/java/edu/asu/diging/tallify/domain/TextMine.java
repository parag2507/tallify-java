package edu.asu.diging.tallify.domain;

public class TextMine {
	
	private String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStopWords() {
		return stopWords;
	}
	public void setStopWords(String stopWords) {
		this.stopWords = stopWords;
	}
	private String stopWords;
	
	
}
