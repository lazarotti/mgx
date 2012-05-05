package br.com.mgx.entity;

import static br.com.mgx.entity.StatusTipo.*;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	
	public Status(StatusTipo statusTipo) {
		this.statusTipo = statusTipo;
	}

	public Status() {
	}

	private Date desde;
	
	@Enumerated(EnumType.STRING)	
	private StatusTipo statusTipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public StatusTipo getStatusTipo() {
		return statusTipo;
	}

	public void setStatusTipo(StatusTipo statusTipo) {
		this.statusTipo = statusTipo;
	}
	
	public List<StatusTipo> getStatusCollection() {
		return Arrays.asList(AGUARDANDO_ORCAMENTO,AGUARDANDO_ENVIO_EMAIL,
				AGUARDANDO_APROVACAO,ORCAMENTO_APROVADO,ORCAMENTO_REPROVADO,
				EXECUTANDO_SERVICO,EQUIPAMENTO_PRONTO_NAO_RETIRADO,
				EQUIPAMENTO_PRONTO_RETIRADO);
	}
	
	
}
