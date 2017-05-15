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
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@ToString
public class Tag {

	@Id
	@Column(name = "Tag_id")
	@GeneratedValue
	private Integer id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="libro_tag", joinColumns=@JoinColumn(name="Tag_id"), inverseJoinColumns=@JoinColumn(name="Libro_id"))
	@Setter private Set<Libro> libri;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="utente_tag", joinColumns=@JoinColumn(name="Tag_id"), inverseJoinColumns=@JoinColumn(name="Utente_id"))
	@Setter private Set<Utente> utentiPref;
}
