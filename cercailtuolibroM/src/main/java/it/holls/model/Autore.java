package it.holls.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@ToString
public class Autore {
	
	@Id
	@Column(name = "Autore_id")
	@GeneratedValue
	private Integer id;
	
	@Setter
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="autore")
	@Setter
	private Set<Libro> libri;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="utente_autore", joinColumns=@JoinColumn(name="Autore_id"), inverseJoinColumns=@JoinColumn(name="Utente_id"))
	@Setter
	private Set<Utente> utentiPref;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
