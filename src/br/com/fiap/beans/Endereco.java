package br.com.fiap.beans;

public class Endereco {

	private int codigo;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco(int codigo, String logradouro, String numero, String bairro, String cidade, String estado,
			String cep) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public void setAll(int codigo, String logradouro, String numero, String bairro, String cidade, String estado,
			String cep) {
		setCodigo(codigo);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
	}
	
	public String getAll(int codigo, String logradouro, String numero, String bairro, String cidade, String estado,
			String cep) {
		return	"Código: " + codigo + "\n" +
					"Logradouro : " + logradouro + "\n" +
						"Número: " + numero + "\n" +
							"Bairro : " + bairro + "\n" +
								"Cidade : " + cidade + "\n" +
									"Estado : " + estado + "\n" +
										"CEP : " + cep;
	}

	public Endereco() {
		super();
	}
		
	
}
