package br.com.mgx.entity;

public enum StatusTipo {
	
	AGUARDANDO_ORCAMENTO("Aguardando realizar orçamento"), 
	AGUARDANDO_ENVIO_EMAIL("Aguardando envio de orcamento (email)"), 	
	AGUARDANDO_APROVACAO("Aguardando aprovação"),
	ORCAMENTO_APROVADO("Orçamento aprovado"),
	ORCAMENTO_REPROVADO("Orçamento reprovado"),
	EXECUTANDO_SERVICO("Executando o serviço"), 
	EQUIPAMENTO_PRONTO_NAO_RETIRADO("Pronto não retirado"),
	EQUIPAMENTO_PRONTO_RETIRADO("Pronto retirado");
	
	private final String label;
	
	StatusTipo(String label) {
		this.label = label;
	}
	
	public final String getLabel(){
		return label;
	}

}
