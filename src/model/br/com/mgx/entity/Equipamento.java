package br.com.mgx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Alessandro Lazarotti
 * @version 1.0
 * @created 24-nov-2007 14:22:19
 */
@Entity
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Fabricante fabricante;
	
	private String nome;
	
	private String numeroSerie;
	
	/* usar suggestBox para interface com o usuario */
	private String modelo;
	
	@ManyToOne
	private TipoEquipamento tipoEquipamento;

	public Equipamento(){

	}
	
	public Equipamento(Long id, Fabricante fabricante, String nome,
			TipoEquipamento tipoEquipamento) {
		super();
		this.id = id;
		this.fabricante = fabricante;
		this.nome = nome;
		this.tipoEquipamento = tipoEquipamento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	

}