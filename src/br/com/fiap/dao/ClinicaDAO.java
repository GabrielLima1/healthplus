package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Clinica;
import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.Conexao;

public class ClinicaDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ClinicaDAO()throws Exception{
		con = Conexao.conectar();
	}
	
	public String gravar(Clinica clin)throws Exception{
		stmt = con.prepareStatement("INSERT INTO CLINICA VALUES (sq_clinica.nextval, ?, ?, ?, ?, ?, 'N', 0, ?, ?, ?)");
		
		stmt.setString(1, clin.getNome());
		stmt.setString(2, clin.getEmail());
		stmt.setString(3, clin.getCnpj());
		stmt.setString(4, clin.getSite());
		stmt.setString(5, clin.getHorario());
		stmt.setString(6, clin.getTelefone());
		stmt.setInt(7, clin.getUsuario().getCodigo());
		stmt.setInt(8, clin.getEndereco().getCodigo());
		
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}
	
	//metodo que consulta por tudo
	public List<Clinica> consultarTudo()throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("select clinica.nome_clinica, especialidade.nome_especialidade from clinica_especialidade " + 
				"JOIN clinica on (clinica.cod_clinica = clinica_especialidade.cod_clinica) " + 
				"join especialidade on (especialidade.cod_especialidade = clinica_especialidade.cod_especialidade) " + 
				"where clinica.delete_clinica = 'N'");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Código
	public Clinica consultarPorCodigo(int codigo)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM CLINICA"+
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE cod_clinica = ? AND delete_clinica = 'N");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					);
		}else {
			return new Clinica();
		}
		
	}
	
	//metodo que consulta por Nome da Clinica
	public List<Clinica> consultarPorNome(String nome)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE nome_clinica LIKE ? AND delete_clinica = 'N");
		stmt.setString(1,"%" + nome + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Email da Clinica
	public List<Clinica> consultarPorEmail(String email)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE email_clinica LIKE ? AND delete_clinica = 'N");
		stmt.setString(1,"%" + email + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Cnpj da Clinica
	public Clinica consultarPorCnpj(String cnpj)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE cnpj_clinica = ? AND delete_clinica = 'N");
		stmt.setString(1, cnpj);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					);
		}else {
		
		return new Clinica();
		}
	}
	
	//metodo que consulta por Site da Clinica
	public List<Clinica> consultarPorSite(String site)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE site_clinica LIKE ? AND delete_clinica = 'N");
		stmt.setString(1,"%" + site + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Horario da Clinica
	public List<Clinica> consultarPorHorario(String horario)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE horario_clinica LIKE ? AND delete_clinica = 'N");
		stmt.setString(1,"%" + horario + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Telefone da Clinica
	public List<Clinica> consultarPorTelefone(String telefone)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA" +
									"INNER JOIN USUARIO ON (CLINICA.cod_usuario = USUARIO.cod_usuario)"+
									"INNER JOIN ENDERECO ON(CLINICA.cod_endereco = ENDERECO.cod_endereco) WHERE telefone_clinica LIKE ? AND delete_clinica = 'N");
		stmt.setString(1,"%" + telefone + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					
					new  Usuario(
							rs.getInt("cod_usuario"),
							rs.getString("nome_usuario"),
							rs.getString("crm_usuario"),
							rs.getString("email_usuario"),
							rs.getString("senha_usuario")),
					
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}
	
	//metodo que consulta por Busca da Clinica
	public List<Clinica> consultarPorBusca()throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA ORDER BY busca_clinica DESC");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"), null ,null));
		}
		
		return lista;
	}
	
	//metodo para buscar por codigo usuario
	public List<Clinica> buscaClinicaPorUsuario(int cod_usuario) throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("select * from clinica join endereco on(endereco.cod_endereco = clinica.cod_endereco) where clinica.cod_usuario = ?");
		stmt.setInt(1, cod_usuario);
		rs  = stmt.executeQuery();
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getInt("cod_clinica"),
					rs.getString("nome_clinica"),
					rs.getString("email_clinica"),
					rs.getString("cnpj_clinica"),
					rs.getString("site_clinica"),
					rs.getString("horario_clinica"),
					rs.getString("delete_clinica"),
					rs.getInt("busca_clinica"),
					rs.getString("telefone_clinica"),
					null,
					new Endereco(
							rs.getInt("cod_endereco"),
							rs.getString("logradouro_endereco"),
							rs.getString("numero_endereco"),
							rs.getString("bairro_endereco"),
							rs.getString("cidade_endereco"),
							rs.getString("estado_endereco"),
							rs.getString("cep_endereco"))
					
					));
		}
		
		return lista;
	}

	//metodo que promove a busca de clinica
	public int promover(int busca)throws Exception{
		stmt = con.prepareStatement("UPDATE CLINICA SET busca_clinica = busca_clinica + 1 WHERE cod_clinica = ?");
		stmt.setInt(1, busca);
		return stmt.executeUpdate();
	}
	
	public String atualizarClinica(Clinica clin)throws Exception{
		stmt = con.prepareStatement("UPDATE CLINICA SET nome_clinica=?, email_clinica=?, site_clinica=?, horario_clinica =?, telefone_clinica=? "+
									"WHERE cod_clinica=? ");
		stmt.setString(1, clin.getNome());
		stmt.setString(2, clin.getEmail());
		stmt.setString(3, clin.getSite());
		stmt.setString(4, clin.getHorario());
		stmt.setString(5, clin.getTelefone());
		stmt.setInt(6, clin.getCodigo());
		stmt.executeUpdate();
		
		return "Clinica Atualizada";
	}
	//metodo que deleta clinica dando update
	public String deletar(String delete)throws Exception{
		stmt = con.prepareStatement("UPDATE CLINICA SET delete_clinica = Y WHERE cod_clinica = ?");
		stmt.setString(1, delete);
		stmt.executeUpdate();
		return "Atualizado com Sucesso!";
	}
	
	//metodo que encerra a conexão com o Banco
	public void fechar()throws Exception{
		con.close();
		
	}
}
