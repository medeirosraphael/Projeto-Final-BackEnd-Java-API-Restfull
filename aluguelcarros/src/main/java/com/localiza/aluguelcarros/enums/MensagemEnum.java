package com.localiza.aluguelcarros.enums;

public enum MensagemEnum {

	CADASTRADO("Cadastrado com sucesso!"),
	ATUALIZADO("Atualizado com sucesso!"),
	EXCLUIDO("Excluido com sucesso!"),
	NAO_EXISTE_ID("Esse Id nao consta em nossa base de dados.");
	
	private String descricao;
	
	MensagemEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
