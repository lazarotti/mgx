package br.com.mgx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Administrator
 * @version 1.0
 * @created 24-nov-2007 14:22:19
 */
@Entity
public class Direito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codigo;
	private String nome;

	public Direito(){

	}

	public Direito(Long id, String codigo, String nome) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



}