package br.com.mgx.repository;

import java.util.Arrays;
import java.util.Date;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.faces.FacesMessages;

import br.com.mgx.dao.DataAccessObject;
import br.com.mgx.entity.OrdemServico;
import br.com.mgx.entity.Status;
import br.com.mgx.entity.StatusTipo;
import br.com.mgx.exception.SiqEntidadeNaoEncontradaException;


@Name("ordemServicoRepositorio")
@AutoCreate
public class OrdemServicoRepositorioSeam implements OrdemServicoRepositorio {
	
	@In
	private DataAccessObject dao;
	
	@In
	private FacesMessages facesMessages;
	
	/* (non-Javadoc)
	 * @see br.com.mgx.repository.OrdemServicoRepositorio#proximoId()
	 */
	public Long proximoNumero(){
		Long ultimoId = null;
		
		try{
			ultimoId = (Long)dao.querySingleResult("select MAX(os.numero) from OrdemServico os");
			ultimoId = ultimoId==null?0:ultimoId;
		}catch(SiqEntidadeNaoEncontradaException e){
			ultimoId = 0L;
		}
		
		return ultimoId+1;
	}
	
	public StatusTipo statusAnterior(Status status){
		
		return (StatusTipo) dao.querySingleResult(" select status.statusTipo from Status status where status.id = ?1",
				new Object[]{status.getId()});

//		return (Status)dao.getById(Status.class, status.getId());
		
		
	}
	
	public boolean existeNumeroOs(OrdemServico os){
		Long amount = (Long)dao.querySingleResult("select count(os) from OrdemServico os where os.numero = ?1 and os.id != ?2 ",new Object[]{os.getNumero(),os.getId()});
		return amount>0;
	}
	
	@Transactional
	public void modifica(OrdemServico os){	
		Status statusAtual = os.getStatus();
		dao.desconecta(os);
		if(statusAnterior(statusAtual) != statusAtual.getStatusTipo())
			statusAtual.setDesde(new Date());
		dao.update(os);
		facesMessages.add("O.S. alterada com sucesso");		
	}
	
	@Transactional
	public void adiciona(OrdemServico os){
		os.getStatus().setStatusTipo(StatusTipo.AGUARDANDO_ORCAMENTO);
		os.getStatus().setDesde(new Date());
		os.setNumero(proximoNumero());
		dao.add(os);
		facesMessages.add("O.S. salva com sucesso");
	}
	
	public Long getQuantidadeDeOrdensComStatus(StatusTipo statusTipo){
		
		return (Long) dao.querySingleResult("select count(os) from OrdemServico os where os.status.statusTipo=?1",
				new Object[]{statusTipo});
	}
	
	public boolean existOsNumber(Long osnumber){
		Long qtde = (Long)dao.querySingleResult("select count(os) from OrdemServico os where os.numero=?1",
				new Object[]{osnumber});
		
		return qtde > 1;
		
	}
	

}
