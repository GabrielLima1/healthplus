package br.com.fiap.beans;

public class Clinica {

		private int codigo;
		private String nome;
		private String email;
		private String cnpj;
		private String site;
		private String horario;
		private String delete;
		private int busca;
		private String telefone;
		private Usuario usuario;
		private Endereco endereco;
		
		
		public int getCodigo() {
			return codigo;
		}
		
		public String getNome() {
			return nome;
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getCnpj() {
			return cnpj;
		}
		
		public String getSite() {
			return site;
		}
		
		public String getHorario() {
			return horario;
		}
		
		public String getDelete() {
			return delete;
		}
		
		public int getBusca() {
			return busca;
		}
		
		public String getTelefone() {
			return telefone;
		}
		
		public Usuario getUsuario() {
			return usuario;
		}
		
		public Endereco getEndereco() {
			return endereco;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}

		public void setDelete(String delete) {
			this.delete = delete;
		}

		public void setBusca(int busca) {
			this.busca = busca;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public Clinica(int codigo, String nome, String email, String cnpj, String site, String horario, String delete,
				int busca, String telefone, Usuario usuario, Endereco endereco) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.email = email;
			this.cnpj = cnpj;
			this.site = site;
			this.horario = horario;
			this.delete = delete;
			this.busca = busca;
			this.telefone = telefone;
			this.usuario = usuario;
			this.endereco = endereco;
		}

		public Clinica() {
			super();
		}
		
		public void setAll (int codigo, String nome, String email, String cnpj, String site, String horario, String delete,
		int busca, String telefone, Usuario usuario, Endereco endereco) {
			setCodigo(codigo);
			setNome(nome);
			setEmail(email);
			setCnpj(cnpj);
			setSite(site);
			setHorario(horario);
			setDelete(delete);
			setBusca(busca);
			setTelefone(telefone);
			setUsuario(usuario);
			setEndereco(endereco);
		}
		
		public String getAll(int codigo, String nome, String email, String cnpj, String site, String horario, String delete,
		int busca, String telefone, Usuario usuario, Endereco endereco) {
			return "Código: " + codigo + "\n"+
					"Nome: " + nome + "\n"+
					"Email: " + email + "\n"+
					"CNPJ: " + cnpj + "\n"+
					"Site: " + site + "\n"+
					"Horário: " + horario + "\n"+
					"Telefone: " + telefone + "\n"+
					"Usuario: " + usuario +  "\n"+
					"Endereco: " + endereco;
		}
			
		
		
		


}
