package it.holls.builders;

import java.util.Date;
import java.util.Set;

import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.model.Tag;

public class LibroBuilder {

	private String titolo;
	private String titoloOriginale;
	private Autore autore;
	private Set<Tag> tags;
	private Integer anno;
	private String smallTrama;
	private String trama;
	private String fonteTrama;
	private String urlImg;
	private boolean isValid;
	private Date inserimentoDB;
	private Date aggiornamentoDB;
	private String linkAmazon;
	private String linkKindle;
	
	public static LibroBuilder anLibroBuilder(){
		return new LibroBuilder();
	}

	public LibroBuilder withTitolo(String titolo) {
		this.titolo = titolo;
		return this;
	}
	public LibroBuilder withTitoloOriginale(String titoloOriginale) {
		this.titoloOriginale = titoloOriginale;
		return this;
	}
	public LibroBuilder withAutore(Autore autore) {
		this.autore = autore;
		return this;
	}
	public LibroBuilder withTags(Set<Tag> tags) {
		this.tags = tags;
		return this;
	}
	public LibroBuilder withAnno(Integer anno) {
		this.anno = anno;
		return this;
	}
	public LibroBuilder withSmallTrama(String smallTrama) {
		this.smallTrama = smallTrama;
		return this;
	}
	public LibroBuilder withTrama(String trama) {
		this.trama = trama;
		return this;
	}
	public LibroBuilder withFonteTrama(String fonteTrama) {
		this.fonteTrama = fonteTrama;
		return this;
	}
	public LibroBuilder withUrlImg(String urlImg) {
		this.urlImg = urlImg;
		return this;
	}
	public LibroBuilder withValid(boolean isValid) {
		this.isValid = isValid;
		return this;
	}
	public LibroBuilder withInserimentoDB(Date inserimentoDB) {
		this.inserimentoDB = inserimentoDB;
		return this;
	}
	public LibroBuilder withAggiornamentoDB(Date aggiornamentoDB) {
		this.aggiornamentoDB = aggiornamentoDB;
		return this;
	}
	public LibroBuilder withLinkAmazon(String linkAmazon) {
		this.linkAmazon = linkAmazon;
		return this;
	}
	public LibroBuilder withLinkKindle(String linkKindle) {
		this.linkKindle = linkKindle;
		return this;
	}
	
	public Libro build(){
		Libro libro = new Libro();
		libro.setAggiornamentoDB(aggiornamentoDB);
		libro.setAnno(anno);
		libro.setAutore(autore);
		libro.setFonteTrama(fonteTrama);
		libro.setInserimentoDB(inserimentoDB);
		libro.setLinkAmazon(linkAmazon);
		libro.setLinkKindle(linkKindle);
		libro.setSmallTrama(smallTrama);
		libro.setTags(tags);
		libro.setTitolo(titolo);
		libro.setTitoloOriginale(titoloOriginale);
		libro.setTrama(trama);
		libro.setUrlImg(urlImg);
		libro.setValid(isValid);
		
		return libro;
	}
	
	
}
