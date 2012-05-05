package br.com.mgx.repository;

import br.com.mgx.entity.StatusTipo;

public interface OrdemServicoRepositorio {

	public abstract Long proximoNumero();
	
	public Long getQuantidadeDeOrdensComStatus(StatusTipo statusTipo);	
	
	

}