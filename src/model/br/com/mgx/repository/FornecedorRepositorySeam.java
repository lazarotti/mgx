package br.com.mgx.repository;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import br.com.mgx.dao.DataAccessObject;
import br.com.mgx.entity.Fornecedor;

@Name("fornecedorRepository")
@AutoCreate
public class FornecedorRepositorySeam {
	
	@In
	DataAccessObject dao;
	
	public Fornecedor buscaFornecedorPorNomeFantasia(String nome){
		return (Fornecedor) dao.querySingleResult("from Fornecedor fornecedor where fornecedor.cadastro.nomeFantasia = "+nome);
	}

}
