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
public class DadosCadastrais {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;

	private String bairro;
	private String categoria;
	private String cep;
	private String cpfCnpj;	
	private String cidade;
	private String complemento;
	private String contato;
	private String email;
	private String endereco;
	private String fax;
	private String inscricao;
	private String nomeFantasia;
	private String obs;
	private String razaoSocial;
	private String telefone1;
	private String telefone2;
	private String uf;

	public DadosCadastrais(){

	}
	
	

	public DadosCadastrais(Long id, String bairro, String categoria,
			String cep, String cidade, String complemento, String contato,
			String email, String endereco, String fax, String inscricao,
			String nomeFantasia, String obs, String razaoSocial,
			String telefone1, String telefone2, String uf) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.categoria = categoria;
		this.cep = cep;
		this.cidade = cidade;
		this.complemento = complemento;
		this.contato = contato;
		this.email = email;
		this.endereco = endereco;
		this.fax = fax;
		this.inscricao = inscricao;
		this.nomeFantasia = nomeFantasia;
		this.obs = obs;
		this.razaoSocial = razaoSocial;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.uf = uf;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}



	public String getCpfCnpj() {
		return cpfCnpj;
	}



	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	
	
}