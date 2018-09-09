package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.PlanoSaude;
import br.com.fiap.conexao.Conexao;

public class PlanoSaudeDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public PlanoSaudeDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	public String gravar(PlanoSaude plan) throws Exception{
		stmt = con.prepareStatement("INSERT INTO PLANO_SAUDE (cod_plano, nome_plano, modalidade_plano) VALUES(?, ?, ?)");
		stmt.setInt(1, plan.getCodigo());
		stmt.setString(2, plan.getNome());
		stmt.setString(3, plan.getModalidade());
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}

	//metodo que consulta tudo 
	public List<PlanoSaude> ConsultaTudo()throws Exception{
		List<PlanoSaude> lista = new ArrayList<PlanoSaude>();
		stmt = con.prepareStatement("SELECT * FROM PLANO_SAUDE");
		stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new PlanoSaude(
					rs.getInt("cod_plano"),
					rs.getString("nome_plano"),
					rs.getString("modalidade_plano")
					));
		}
		return lista;
	}
	
	//metodo que consulta nome
	public List<PlanoSaude> ConsultarPorNome(String nome) throws Exception{
		List<PlanoSaude> lista = new ArrayList<PlanoSaude>();
		stmt = con.prepareStatement("SELECT * FROM PLANO_SAUDE WHERE nome_plano LIKE ?");
		stmt.setString(1, "%" + nome + "%");
		stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new PlanoSaude(
					rs.getInt("cod_plano"),
					rs.getString("nome_plano"),
					rs.getString("modalidade_plano")
					));
		}
		return lista;
	}
	
	//metodo que consulta modalidade
	public List<PlanoSaude> ConsultarPorModalidade(String modalidade) throws Exception{
		List<PlanoSaude> lista = new ArrayList<PlanoSaude>();
		stmt = con.prepareStatement("SELECT * FROM PLANO_SAUDE WHERE modalidade_plano LIKE ?");
		stmt.setString(1, "%" + modalidade + "%");
		stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new PlanoSaude(
					rs.getInt("cod_plano"),
					rs.getString("nome_plano"),
					rs.getString("modalidade_plano")
					));
		}
		return lista;
	}
	
	//metodo que delete usuario atraves do cod_plano
		public int apagar(int numero) throws Exception{
			stmt = con.prepareStatement("DELETE FROM USUARIO WHERE cod_plano = ?");
			stmt.setInt(1, numero);
			return stmt.executeUpdate();
		}
		
		// metodo para fechar conexão com o banco
			public void fechar() throws Exception{
				con.close();
			}
	
}
