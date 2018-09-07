package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.FormularioContato;
import br.com.fiap.conexao.Conexao;

public class FormularioContatoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public FormularioContatoDAO() throws Exception {
		con = Conexao.conectar();
	}
	
	
	public String gravar(FormularioContato form) throws Exception{
		stmt = con.prepareStatement("INSERT INTO FORMULARIO_CONTATO (cod_contato,nome_contato,email_contato,mensagem_contato,tipo_contato) VALUES(?,?,?,?,?)");
		stmt.setInt(1, form.getCodigo());
		stmt.setString(2, form.getNome());
		stmt.setString(3, form.getEmail());
		stmt.setString(4, form.getMensagem());
		stmt.setString(5, form.getTipo());
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}
	
	public List<FormularioContato> trasTudo() throws Exception {
		List<FormularioContato> form = new ArrayList<FormularioContato>();
		stmt = con.prepareStatement("SELECT * FROM FORMULARIO_CONTATO");
		rs = stmt.executeQuery();
		while(rs.next()) {
			form.add(new FormularioContato(rs.getInt("cod_contato"),
										   rs.getString("nome_contato"),
										   rs.getString("email_contato"),
										   rs.getString("mensagem_contato"),
										   rs.getString("tipo_contato")));
		}
		
		return form;
		
	}
	
	// metodo para consultar pelo tipo
	public List<FormularioContato> consultarPorTipo(String tipo) throws Exception {
		List<FormularioContato> form = new ArrayList<FormularioContato>();
		stmt = con.prepareStatement("SELECT * FROM FORMULARIO_CONTATO WHERE tipo_contato LIKE ?");
		stmt.setString(1, "%"+tipo+"%");
		rs = stmt.executeQuery();
		while(rs.next()) {
			form.add(new FormularioContato(rs.getInt("cod_contato"),
										   rs.getString("nome_contato"),
										   rs.getString("email_contato"),
										   rs.getString("mensagem_contato"),
										   rs.getString("tipo_contato")));
		}
		
		return form;
		
	}
	
	// metodo para consultar pelo email
	public List<FormularioContato> consultarPorEmail(String email) throws Exception {
		List<FormularioContato> form = new ArrayList<FormularioContato>();
		stmt = con.prepareStatement("SELECT * FROM FORMULARIO_CONTATO WHERE email_contato LIKE ?");
		stmt.setString(1, "%"+email+"%");
		rs = stmt.executeQuery();
		while(rs.next()) {
			form.add(new FormularioContato(rs.getInt("cod_contato"),
										   rs.getString("nome_contato"),
										   rs.getString("email_contato"),
										   rs.getString("mensagem_contato"),
										   rs.getString("tipo_contato")));
		}
		
		return form;
		
	}
	
	
	// metodo para consultar pela mensagem
	public List<FormularioContato> consultarPorMensagem(String mensagem) throws Exception {
		List<FormularioContato> form = new ArrayList<FormularioContato>();
		stmt = con.prepareStatement("SELECT * FROM FORMULARIO_CONTATO WHERE mensagem_contato LIKE ?");
		stmt.setString(1, "%"+mensagem+"%");
		rs = stmt.executeQuery();
		while(rs.next()) {
			form.add(new FormularioContato(rs.getInt("cod_contato"),
										   rs.getString("nome_contato"),
										   rs.getString("email_contato"),
										   rs.getString("mensagem_contato"),
										   rs.getString("tipo_contato")));
		}
		
		return form;
		
	}
	
	public int apagar(int numero) throws Exception{
		stmt = con.prepareStatement("DELETE FROM FORMULARIO_CONTATO WHERE cod_contato = ?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	
	// metodo para fechar conexão com o banco
	public void fechar() throws Exception{
		con.close();
	}
	
	
}
