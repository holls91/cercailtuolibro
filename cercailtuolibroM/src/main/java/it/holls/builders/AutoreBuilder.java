package it.holls.builders;

import java.util.HashSet;
import java.util.Set;

import it.holls.model.Autore;
import it.holls.model.Libro;

public class AutoreBuilder {

	private String nome;
	private Set<Libro> libri;
	
	public static AutoreBuilder anAutoreBuilder(){
		return new AutoreBuilder();
	}
	
	public AutoreBuilder withNome(String nome){
		this.nome = nome;
		return this;
	}

	public AutoreBuilder withLibro(Libro libro){
		if(libri==null) {
			libri = new HashSet<Libro>();
		}
		this.libri.add(libro);
		return this;
	}
	public AutoreBuilder withLibri(Set<Libro> libri){
		if(libri==null) {
			libri = new HashSet<Libro>();
		}
		this.libri.addAll(libri);
		return this;
	}
	
	public Autore build(){
		Autore autore = new Autore();
		autore.setLibri(libri);
		autore.setNome(nome);
		
		return autore;
	}
}
