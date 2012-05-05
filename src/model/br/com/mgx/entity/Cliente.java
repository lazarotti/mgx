package br.com.mgx.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Administrator
 * @version 1.0
 * @created 24-nov-2007 14:22:19
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;	
		
	@ManyToOne(cascade=CascadeType.ALL)
	private DadosCadastrais cadastro;
	
	@OneToOne	
	private Usuario usuario;
	
	@OneToMany(mappedBy="cliente")
	private Set<OrdemServico> ordensServico;
	
	
	public Cliente(){
		cadastro = new DadosCadastrais();
	}

	public Cliente(Long id, DadosCadastrais cadastro, Usuario usuario) {
		super();
		this.id = id;
		this.cadastro = cadastro;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<OrdemServico> getOrdensServico() {
		return ordensServico;
	}

	public void setOrdensServico(Set<OrdemServico> ordensServico) {
		this.ordensServico = ordensServico;
	}


}