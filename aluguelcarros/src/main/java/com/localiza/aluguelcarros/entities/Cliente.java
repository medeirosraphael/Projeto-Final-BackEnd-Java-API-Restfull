package com.localiza.aluguelcarros.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "cnh", length = 30, nullable = false)
	private String cnh;
	@Column(name = "telefone", length = 30, nullable = false)
	private String telefone;
	@Column(name = "endereço", length = 100, nullable = false)
	private String endereço;
	@Column(name = "locacao", length = 100, nullable = false)
	private String locacao;
	@Column(name = "imagem", length = 100, nullable = false)
	private String imagem;
	@Column(name = "idade", length = 100, nullable = false)
	private Integer idade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public String getLocacao() {
		return locacao;
	}
	public void setLocacao(String locacao) {
		this.locacao = locacao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	

}
