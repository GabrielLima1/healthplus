	package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.Conexao;

public class UsuarioDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UsuarioDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	//gravação de novo usuario
	public String  gravar(Usuario us) throws Exception{
		stmt = con.prepareStatement("INSERT INTO USUARIO (cod_usuario, nome_usuario, email_usuario, senha_usuario) VALUES (?,?,?,?)");
		stmt.setInt(1, us.getCodigo());
		stmt.setString(2, us.getNome());
		stmt.setString(3, us.getEmail());
		stmt.setString(4, us.getSenha());
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
		
	}
	
	//metodo que consulta tudo em nossa base
	public List<Usuario> ConsultaTudo() throws Exception{
		List<Usuario> lista = new ArrayList<Usuario>();
		stmt = con.prepareStatement("SELECT * FROM USUARIO");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new  Usuario(
						rs.getInt("cod_usuario"),
						rs.getString("nome_usuario"),
						rs.getString("email_usuario"),
						rs.getString("senha_usuario")	
					));
		}
			return lista;
	}
	
	//metodo que consulta por nome
	public List<Usuario> ConsultarPorNome(String nome) throws Exception{
		List<Usuario> lista =  new ArrayList<Usuario>();
		stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE nome_usuario LIKE ?");
		stmt.setString(1, "%" + nome + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new  Usuario(
						rs.getInt("cod_usuario"),
						rs.getString("nome_usuario"),
						rs.getString("email_usuario"),
						rs.getString("senha_usuario")	
					));
		}
			return lista;
	}
	
	//metodo que  consulta por email
	public List<Usuario> ConsultarPorEmail(String email) throws Exception{
		List<Usuario> lista =  new ArrayList<Usuario>();
		stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE email_usuario LIKE ?");
		stmt.setString(1, "%" + email + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new  Usuario(
						rs.getInt("cod_usuario"),
						rs.getString("nome_usuario"),
						rs.getString("email_usuario"),
						rs.getString("senha_usuario")	
					));
		}
			return lista;
	}
	
	//metodo que delete usuario atraves do cod_usuario
	public int apagar(int numero) throws Exception{
		stmt = con.prepareStatement("DELETE FROM USUARIO WHERE cod_usuario = ?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	
	// metodo para fechar conexão com o banco
		public void fechar() throws Exception{
			con.close();
		}
}
