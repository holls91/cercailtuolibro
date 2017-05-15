package it.holls.builders;

import java.util.Date;
import java.util.Set;

import it.holls.model.Autore;
import it.holls.model.Libro;
import it.holls.model.Ruolo;
import it.holls.model.Tag;
import it.holls.model.Utente;

public class UtenteBuilder {

	private String username;
	private String password;
	private String email;
	private Ruolo ruolo;
	private String urlAvatar;
	private String ip;
	private Date dataRegistrazione;
	private Set<Libro> libriPreferiti;
	private Set<Tag> tagPreferiti;
	private Set<Autore> autoriPreferiti;
	
	public UtenteBuilder withUsername(String username) {
		this.username = username;
		return this;
	}
	public UtenteBuilder withPassword(String password) {
		this.password = password;
		return this;
	}
	public UtenteBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	public UtenteBuilder withRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
		return this;
	}
	public UtenteBuilder withUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
		return this;
	}
	public UtenteBuilder withIp(String ip) {
		this.ip = ip;
		return this;
	}
	public UtenteBuilder withDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
		return this;
	}
	public UtenteBuilder withLibriPreferiti(Set<Libro> libriPreferiti) {
		this.libriPreferiti = libriPreferiti;
		return this;
	}
	public UtenteBuilder withTagPreferiti(Set<Tag> tagPreferiti) {
		this.tagPreferiti = tagPreferiti;
		return this;
	}
	public UtenteBuilder withAutoriPreferiti(Set<Autore> autoriPreferiti) {
		this.autoriPreferiti = autoriPreferiti;
		return this;
	}
	
	public Utente build(){
		Utente utente = new Utente();
		utente.setAutoriPreferiti(autoriPreferiti);
		utente.setDataRegistrazione(dataRegistrazione);
		utente.setEmail(email);
		utente.setIp(ip);
		utente.setLibriPreferiti(libriPreferiti);
		utente.setPassword(password);
		utente.setRuolo(ruolo);
		utente.setTagPreferiti(tagPreferiti);
		utente.setUrlAvatar(urlAvatar);
		utente.setUsername(username);
		
		return utente;
	}
	
	
	
}
