package br.com.fiap.beans;

public class FormularioContato {
	private int codigo;
	private String nome;
	private String email;
	private String mensagem;
	private String tipo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;		
	}	
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public FormularioContato(int codigo, String nome, String email, String mensagem, String tipo) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setMensagem(mensagem);
		setTipo(tipo);
	}
	
	public void setAll(int codigo, String nome, String email, String mensagem, String tipo) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setMensagem(mensagem);
		setTipo(tipo);
	}
	
	public String getAll() {
		return "Codigo: " + codigo+ "\n"+
				"Nome: " + nome + "\n" +
				"Email: " + email + "\n" +
				"Mensagem: " + mensagem + "\n" +
				"Tipo da Mensagem:" + tipo;
	}
	
	public FormularioContato() {
		super();
	}
	
	
	
}
