package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
