package br.com.fiap.beans;

public class Especialidade extends Clinica{
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public void setAll(int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}

	public String getAll(int codigo, String nome) {
		return "Codigo: " + codigo+ "\n"+
				"Nome: " + nome;
	}
	
	public Especialidade() {
		super();
	}
	
	

}
