package br.com.mgx.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author Administrator
 * @version 1.0
 * @created 24-nov-2007 14:22:20
 */
@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany
	private Set<Direito> direitos;
	
	private String nome;

	public Grupo(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Direito> getDireitos() {
		return direitos;
	}

	public void setDireitos(Set<Direito> direitos) {
		this.direitos = direitos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



}