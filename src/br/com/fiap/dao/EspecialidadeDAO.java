package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.conexao.Conexao;

public class EspecialidadeDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public EspecialidadeDAO() throws Exception{
		con = Conexao.conectar();
	}
	//metodo de gravar especialidade
	public String gravar(Especialidade esp)throws Exception{
		stmt = con.prepareStatement("INSERT INTO ESPECIALIDADE VALUES(sq_especialidade.nextval, ?)");
		stmt.setString(1, esp.getNome());
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}
	
	//metodo de consulta tudo
	public List<Especialidade> consultarTudo() throws Exception{
		List<Especialidade> lista = new ArrayList<Especialidade>();
		stmt = con.prepareStatement("SELECT * FROM ESPECIALIDADE");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Especialidade(
					rs.getInt("cod_especialidade"),
					rs.getString("nome_especialidade")
					));
		}
		return lista;
	}
	
	//metodo de consulta por codigo
	public Especialidade consultarPorCodigo(int codigo)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM ESPECIALIDADE WHERE cod_especialidade = ?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Especialidade(
					rs.getInt("cod_especialidade"),
					rs.getString("nome_especialidade")
					);
		}
		else {
			return new Especialidade();
		}
	}
	
	//metodo de consulta por nome
	public Especialidade consultarPorNome(String nome)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM ESPECIALIDADE WHERE nome_especialidade LIKE ?");
		stmt.setString(1, "%" + nome +"%" );
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return  new Especialidade(
					rs.getInt("cod_especialidade"),
					rs.getString("nome_especialidade")
					);
		}
		
		return new Especialidade();
	}
	
	//metodo que atualiza  a Especialidade
	public String atualizaEspecialidade(Especialidade esp)throws Exception{
		stmt = con.prepareStatement("UPDATE ESPECIALIDADE SET nome_especialidade = ? WHERE cod_especialidade = ?");
		stmt.setString(1, esp.getNome());
		stmt.setInt(2, esp.getCodigo());
		stmt.executeUpdate();
		return "Especialidade Atualizada!";
	}
	
	//metodo que apaga por cod_especialidade
	public int apagar(int numero)throws Exception{
		stmt = con.prepareStatement("DELETE FROM ESPECIALIDADE WHERE cod_especialidade = ?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	
	//metodo que fecha conexao com o banco
	public void fechar()throws Exception{
		con.close();
	}
	
}
