package br.com.mgx.service;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.faces.Renderer;

import br.com.mgx.entity.Cliente;
import br.com.mgx.entity.DadosCadastrais;
import br.com.mgx.entity.Equipamento;
import br.com.mgx.entity.Fornecedor;
import br.com.mgx.entity.OrdemServico;
import br.com.mgx.entity.StatusTipo;
import br.com.mgx.exception.SiqEntidadeNaoEncontradaException;
import br.com.mgx.helper.DownloadGateway;
import br.com.mgx.repository.ClienteRepositorioSeam;
import br.com.mgx.repository.FornecedorRepositorySeam;
import br.com.mgx.repository.OrdemServicoRepositorio;
import br.com.mgx.repository.OrdemServicoRepositorioSeam;


/*
 * 

 * 

 * 

 * Cor diferente - se atraso mais que x dias (5 dias email, e 3 dias para aprovacao/executando (de entrega)).
 * Deixar so o botao de salvar em OS
 * 
 * Status automatico para quando data reitrada preenchido estatus mudar para pronto retirado 
 * 
 * 
 * */

@Name("gerenciadorOS")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class GerenciadorOrdemServico {
	
	private OrdemServico ordemServico;
	
	private String clienteNome;
	
	private String ac;
	
	@Out(required=false)
	private Map<String, Long> resumo;
	
	@In
	private OrcamentoReport orcamentoReport;
	
	@In
	private ComprovanteReport comprovanteReport;
	
    @In
    DownloadGateway downloadGateway;	
	
	@In
	private OrdemServicoRepositorioSeam ordemServicoRepositorio;
	
	@In
	private ClienteRepositorioSeam clienteRepositorio;	
	
	@In(create=true)
	private Renderer renderer;	
	
	@In(create=true)
	FacesMessages facesMessages;
	
	@Out(scope=ScopeType.EVENT, required=false)
	public byte[] relatorio;
	
	public GerenciadorOrdemServico(){
		System.out.println("Instanciando o Gerenciador de Ordem de Servico");
	}

	public void teste(){
		
	}
	
	@Factory("resumo")
	public Map<String, Long> dadosResumo(){
		Map map = new HashMap<String, Long>();
		map.put("aguardandoAprovacao",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.AGUARDANDO_APROVACAO));		
		map.put("aguardandoEnvioEmail",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.AGUARDANDO_ENVIO_EMAIL));
		map.put("aguardandoOrcamento",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.AGUARDANDO_ORCAMENTO));
		map.put("orcamentoAprovado",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.ORCAMENTO_APROVADO));		
		map.put("executandoServico",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.EXECUTANDO_SERVICO));
		map.put("orcamentoReprovado",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.ORCAMENTO_REPROVADO));
		map.put("equipamentoProntoRetirado",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.EQUIPAMENTO_PRONTO_RETIRADO));
		map.put("equipamentoProntoNaoRetirado",ordemServicoRepositorio.getQuantidadeDeOrdensComStatus(StatusTipo.EQUIPAMENTO_PRONTO_NAO_RETIRADO));
		return map;
	}
	
	@Begin(join=true)
	public void novaOrdem(Equipamento equipamento){
		ordemServico= new OrdemServico();		
		//Long numero = ordemServicoRepositorio.proximoNumero();
		//ordemServico.setNumero(numero);
		ordemServico.setEquipamento(equipamento);
	}	
	

	@Begin(join=true)
	public void editarOrdem(OrdemServico ordemServico){
		this.ordemServico = ordemServico;
	}
	
	public void salvarOrdem(){
	
		try{
			 if(ordemServico.getCliente()==null){
				Cliente cliente = clienteRepositorio.buscaClientePorNomeFantasia(clienteNome);
				ordemServico.setCliente(cliente);
			 }
			 ordemServicoRepositorio.adiciona(ordemServico);
		}catch(SiqEntidadeNaoEncontradaException e){
			facesMessages.add("Cliente fornecido nao existe");
		}			
	}
	
	public void adicionaCliente(){
		
		Cliente cliente = null;
		try{
			 cliente = clienteRepositorio.buscaClientePorNomeFantasia(clienteNome);
			 ordemServico.setCliente(cliente);
			 System.out.println("valor de clienteNome "+ clienteNome);
		}catch(SiqEntidadeNaoEncontradaException e){
			facesMessages.add("Cliente fornecido nao existe");
		}			
		
	}
	
	
	public void modificaOrdem(){
		Cliente cliente = null;
		try{
			 if(ordemServicoRepositorio.existeNumeroOs((ordemServico))){
				 facesMessages.add("Ja existe OS com este numero");
			 }else{
				 cliente = clienteRepositorio.buscaClientePorNomeFantasia(clienteNome);
				 ordemServico.setCliente(cliente);
				 ordemServicoRepositorio.modifica(ordemServico);
			 }
		}catch(SiqEntidadeNaoEncontradaException e){
			facesMessages.add("Cliente fornecido nao existe");
		}
			
	}		
	
	public void gerarOrcamento()throws Exception{
		orcamentoReport.setOrdemServico(ordemServico);
		byte[] relatorio = orcamentoReport.gerarRelatorio();
        downloadGateway.doDownload("orcamento.pdf", relatorio);
	}

	@Transactional
	public void enviarOrcamento(){
	    try {
	    	orcamentoReport.setOrdemServico(ordemServico);	    	
	    	relatorio = orcamentoReport.gerarRelatorio();
	        renderer.render("/email/envio-orcamento.xhtml");

	        //limpar deste objeto em conversacao
	        relatorio = null;
	        
	        //se enviar o email e tiver status anterior, mudar para aguardando aprovacao
	        if(ordemServico.getStatus().getStatusTipo().equals(StatusTipo.AGUARDANDO_ORCAMENTO) ||
	        		ordemServico.getStatus().getStatusTipo().equals(StatusTipo.AGUARDANDO_ENVIO_EMAIL)){
	        	
		        ordemServico.aguardarAprovacao();
	        	ordemServicoRepositorio.modifica(ordemServico);	        

	        }
	        
	        facesMessages.add("Email enviado com sucesso");
	    } 
	    catch (Exception e) {
	        facesMessages.add("Falha no envio de email: " + e.getMessage());
	        e.printStackTrace();
	    }		
	}
	
	public List<Cliente> buscaClientes(Object nomeFantasia){
		return clienteRepositorio.buscaClientesDiferentesDoAtual(nomeFantasia, this.ordemServico.getCliente());
	}
	
	public void emitirComprovante() throws Exception{
	    	comprovanteReport.setOrdemServico(ordemServico);	    	
	    	relatorio = comprovanteReport.gerarRelatorio();	        
			byte[] relatorio = comprovanteReport.gerarRelatorio();	    
	        downloadGateway.doDownload("comprovante.pdf", relatorio);	    	
	}
	
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public byte[] getRelatorio() {
		return relatorio;
	}

	public String getClienteNome() {
		if(ordemServico.getCliente()!= null)			
			return ordemServico.getCliente().getCadastro().getNomeFantasia();
		else
			return "";
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	
}
