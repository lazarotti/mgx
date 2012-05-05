package br.com.mgx.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.com.mgx.dao.DataAccessObject;
import br.com.mgx.entity.Cliente;
import br.com.mgx.entity.Fornecedor;

@Name("clienteRepositorio")
@AutoCreate
public class ClienteRepositorioSeam {
	
	@In
	private DataAccessObject dao;
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscaClientesDiferentesDoAtual(Object nomeFantasia, Cliente clienteAtual){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		StringBuffer hql = new StringBuffer("select distinct cliente from Cliente cliente where");
		if(clienteAtual!=null && clienteAtual.getId() != null){
			map.put("id", clienteAtual.getId());
			hql.append(" cliente.id != :id and ");	
		}
		map.put("nome", "%" + nomeFantasia + "%");
		hql.append(" cliente.cadastro.nomeFantasia like :nome ");
		
		
		return dao.query(hql.toString(),map);
	}
	
	public Cliente buscaClientePorNomeFantasia(String nome){
		return (Cliente) dao.querySingleResult("from Cliente cliente where cliente.cadastro.nomeFantasia = ?1",new Object[]{nome});
	}
	
	

}
