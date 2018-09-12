package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Clinica;
import br.com.fiap.conexao.Conexao;

public class ClinicaDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ClinicaDAO()throws Exception{
		con = Conexao.conectar();
	}
	
	public String gravar(Clinica clin)throws Exception{
		stmt = con.prepareStatement("INSERT INTO CLINICA (NOME,LOGRADOURO,BAIRRO,CIDADE,ESTADO,TELEFONE,EMAIL,CNPJ,SITE,CEP,HORARIO) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, clin.getNome());
		stmt.setString(2, clin.getLogradouro());
		stmt.setString(3, clin.getBairro());
		stmt.setString(4, clin.getCidade());
		stmt.setString(5, clin.getEstado());
		stmt.setString(6, clin.getTelefone());
		stmt.setString(7, clin.getEmail());
		stmt.setString(8, clin.getCnpj());
		stmt.setString(9, clin.getSite());
		stmt.setString(10, clin.getCep());
		stmt.setString(11, clin.getHorario());
		stmt.setString(12, clin.getPlano().getNome());
		
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}
	
	public List<Clinica> consultarPorNome(String nome)throws Exception{
		List<Clinica> lista = new ArrayList<Clinica>();
		stmt = con.prepareStatement("SELECT * FROM CLINICA WHERE NOME LIKE ?");
		stmt.setString(1, "%" + nome + "%");
		stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Clinica(
					rs.getString("NOME"),
					rs.getString("LOGRADOURO"),
					rs.getString("BAIRRO"),
					rs.getString("CIDADE"),
					rs.getString("ESTADO"),
					rs.getString("TELEFONE"),
					rs.getString("EMAIL"),
					rs.getString("CNPJ"),
					rs.getString("SITE"),
					rs.getString("CEP"),
					rs.getString("HORARIO"),
					new Plano (rs.getInt("COD_PLANO"), rs.getString("NOME_PLANO"))
					rs.getString("ESPECIALIDADE")
					));
		}
		return lista;
	}

}
