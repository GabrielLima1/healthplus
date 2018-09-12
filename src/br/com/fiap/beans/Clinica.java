package br.com.fiap.beans;

public class Clinica {

		private String nome;
		private String logradouro;
		private String bairro;
		private String cidade;
		private String estado;
		private String cep;
		private String telefone;
		private String site;
		private String email;
		private String cnpj;
		private String horario;
		private Especialidade especialidade;
		private PlanoSaude plano;
			
		
		public Clinica() {
			super();
		}


		public Clinica(String nome, String logradouro, String bairro, String cidade, String estado, String cep,
				String telefone, String site, String email, String cnpj, String horario, Especialidade especialidade,
				PlanoSaude plano) {
			super();
			setNome(nome);
			setLogradouro(logradouro);
			setBairro(bairro);
			setCidade(cidade);
			setEstado(estado);
			setCep(cep);
			setTelefone(telefone);
			setSite(site);
			setEmail(email);
			setCnpj(cnpj);
			setHorario(horario);
			setEspecialidade(especialidade);
			setPlano(plano);
		}
		
		
		public void setAll(String nome, String logradouro, String bairro, String cidade, String estado, String cep,
				String telefone, String site, String email, String cnpj, String horario, Especialidade especialidade,
				PlanoSaude plano) {
			setNome(nome);
			setLogradouro(logradouro);
			setBairro(bairro);
			setCidade(cidade);
			setEstado(estado);
			setCep(cep);
			setTelefone(telefone);
			setSite(site);
			setEmail(email);
			setCnpj(cnpj);
			setHorario(horario);
			setEspecialidade(especialidade);
			setPlano(plano);
		}
		
		public String getAll(){
			return	"Nome: " + nome + "\n" +
					"Logradouro : " + logradouro + "\n" +
					"Bairro : " + bairro + "\n" +
					"Cidade : " + cidade + "\n" +
					"Estado : " + estado + "\n" +
					"CEP : " + cep + "\n" +
					"Telefone : " + telefone + "\n" +
					"Site : " + site + "\n" +
					"Email : " + email + "\n" +
					"CNPJ : " + cnpj + "\n" +
					"Horario : " + horario + "\n" +
					"Especialidade : " + especialidade.getAll() + "\n" +
					"Plano de Saúde : " + plano.getAll();		
			}
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome.toUpperCase();
			if(nome.length() <= 40) {
				this.nome = nome;
			} else {
				this.nome = nome.substring(0, 40);
			}
		}
		public String getLogradouro() {
			return logradouro;
		}
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
			if(logradouro.length() <= 150) {
				this.logradouro = logradouro;
			} else {
				this.logradouro = logradouro.substring(0, 150);
				}
		}
		public String getBairro() {
			return bairro;

		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
			if(bairro.length() <= 40) {
				this.bairro = bairro;
			} else {
				this.bairro = bairro.substring(0, 40);
			}
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
			if(cidade.length() <= 50) {
				this.cidade = cidade;
			} else {
				this.cidade = cidade.substring(0, 50);
			}
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
			if(cep.length() <= 10) {
				this.cep = cep;
			} else {
				this.cep = cep.substring(0, 10);
			}
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
			if(telefone.length() <= 10) {
				this.telefone = telefone;
			} else {
				this.telefone = telefone.substring(0, 10);
				}
		}
		public String getSite() {
			return site;
		}
		public void setSite(String site) {
			this.site = site;
			if(site.length() <= 60) {
				this.site = site;
			} else {
				this.site = site.substring(0, 60);
			}
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email.toLowerCase();
			if(email.indexOf(".") < 0 || email.indexOf("@") < 0) {
				this.email = "erro@erro.com.br";
			} else {
				this.email = email.toLowerCase();	
			}
			if(email.length() <= 30) {
				this.email = email;
			} else {
				this.email = email.substring(0, 30);
			}

		}
		public String getCnpj() {
			return cnpj;
		}
		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
			if(cnpj.length() <= 18) {
				this.cnpj = cnpj;
			} else {
				this.cnpj = cnpj.substring(0, 18);
			}
		}
		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
			if(horario.length() <= 25) {
				this.horario = horario;
			} else {
				this.horario = horario.substring(0, 25);
			}
		}
		public Especialidade getEspecialidade() {
			return especialidade;
		}
		public void setEspecialidade(Especialidade especialidade) {
			this.especialidade = especialidade;
		}
		public PlanoSaude getPlano() {
			return plano;
		}
		public void setPlano(PlanoSaude plano) {
			this.plano = plano;
		}
		
		


}
