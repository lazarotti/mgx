package br.com.mgx.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static br.com.mgx.entity.StatusTipo.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.jboss.seam.annotations.In;

import br.com.mgx.repository.OrdemServicoRepositorio;

/**
 * @author Alessandro Lazarotti
 * @version 1.0
 * @created 24-nov-2007 14:22:20
 */
@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Cliente cliente;
	
	private Date dataEntrada;
	private Date dataRetirada;
	private String defeitoRelatado;
	private Long numero;
	private String observacao;	
	
	@Transient @In
	private OrdemServicoRepositorio ordemServicoRepositorio;

	@ManyToOne
	private Equipamento equipamento = new Equipamento();

	@ManyToOne
	private Garantia garantia;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Status status = new Status();

	@ManyToOne
	private Pagamento pagamento;
	
	private String solucaoAdotada;

	
	@ManyToOne
	private Tecnico tecnico;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "ORDEMSERVIC0_ACESSORIO", 
			joinColumns = { @JoinColumn(name = "ID_ORDEMSERVICO") }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_ACESSORIO") })	
	private List<Acessorio> acessorios = new ArrayList<Acessorio>();
	
	
	private Double valor;

	public OrdemServico() {
		

		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) { 
		this.dataEntrada = dataEntrada;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public String getDefeitoRelatado() {
		return defeitoRelatado;
	}

	public void setDefeitoRelatado(String defeitoRelatado) {
		this.defeitoRelatado = defeitoRelatado;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public String getSolucaoAdotada() {
		return solucaoAdotada;
	}

	public void setSolucaoAdotada(String solucaoAdotada) {
		this.solucaoAdotada = solucaoAdotada;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public void aguardarAprovacao(){
		status.setStatusTipo(StatusTipo.AGUARDANDO_APROVACAO);
		status.setDesde(new Date());
	}
	
}