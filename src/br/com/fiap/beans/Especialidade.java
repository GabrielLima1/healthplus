package br.com.fiap.beans;

public class Especialidade {
	private String nome;

	
	
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


	public Especialidade(String nome) {
		super();
		setNome(nome);
	}


	public Especialidade() {
		super();
	}
	
	
	public void setAll(String nome) {
		setNome(nome);
	}
	
	public String getAll() {
		return nome;
	}
	

}
