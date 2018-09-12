package br.com.fiap.beans;

public class PlanoSaude {
	private int codigo;
	private String nome;
	private String modalidade;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getModalidade() {
		return modalidade;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public PlanoSaude(int codigo, String nome, String modalidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.modalidade = modalidade;
	}

	public PlanoSaude() {
		super();
	}
	
	public void setAll(int codigo, String nome, String modalidade) {
		setCodigo(codigo);
		setNome(nome);
		setModalidade(modalidade);
	} 
	
	public String getAll() {
		return "Código: " + codigo + "\n"  +
				"Nome: " + nome + "\n" + 
				"Modalidade" + modalidade ;	
	}
	
	
	
	
	
	
	
}
