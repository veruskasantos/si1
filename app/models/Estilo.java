package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Estilo {

	@Id
	@GeneratedValue
	private Long id;
	
	// Relação Muitos para Muitos
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<Anuncio> anuncios;
	
	private String nome;
	
	public Estilo(){
		this.anuncios = new ArrayList<Anuncio>();
	}
	
	 public Estilo(String nome){
		 this.nome = nome;
	 }
	
	 public List<Anuncio> getAnuncios() {
			return Collections.unmodifiableList(anuncios);
		}
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
