package br.com.fiap.beans;

public class PlanoDeSaude {
	private String nome;
	private String modalidade;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		if(nome.length() <= 30) {
			this.nome = nome;
		}	else {
			this.nome = nome.substring(0, 30);
		}
	}
	
	public String getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
		if(modalidade.length() <= 30) {
			this.modalidade = modalidade;
		}	else {
			this.modalidade = modalidade.substring(0, 30);
		}
	}
	
	public PlanoDeSaude(String nome, String modalidade) {
		setNome(nome);
		setModalidade(modalidade);
	}
	
	public void setAll(String nome, String modalidade) {
		setNome(nome);
		setModalidade(modalidade);
	}
	
	public String getAll() {
		return	nome + " " + modalidade; 
	}
	
	public PlanoDeSaude() {
		super();
	}
	
	
}
