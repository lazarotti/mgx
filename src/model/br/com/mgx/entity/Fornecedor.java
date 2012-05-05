package br.com.mgx.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Administrator
 * @version 1.0
 * @created 24-nov-2007 14:22:20
 */
@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private DadosCadastrais cadastro;

	public Fornecedor(){
		cadastro = new DadosCadastrais();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DadosCadastrais getCadastro() {
		return cadastro;
	}

	public void setCadastro(DadosCadastrais cadastro) {
		this.cadastro = cadastro;
	}
}