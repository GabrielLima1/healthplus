package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexao.Conexao;

public class EnderecoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public EnderecoDAO() throws  Exception{
		con = Conexao.conectar();
	}
	
	//metodo que grava novo endereco
	public String gravar(Endereco  end) throws Exception{
		stmt = con.prepareStatement("INSERT INTO ENDERECO VALUES(sq_endereco.nextval, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, end.getLogradouro());
		stmt.setString(2, end.getNumero());
		stmt.setString(3, end.getBairro());
		stmt.setString(4, end.getCidade());
		stmt.setString(5, end.getEstado());
		stmt.setString(6, end.getCep());
		stmt.executeUpdate();
		return "Cadastrado com Sucesso!";
	}

	//metodo que consulta tudo
	public List<Endereco> consultarTudo()throws Exception{
		List<Endereco> lista = new ArrayList<Endereco>();
		stmt = con.prepareStatement("SELECT * FROM ENDERECO");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Endereco(
					rs.getInt("cod_endereco"),
					rs.getString("logradouro_endereco"),
					rs.getString("numero_endereco"),
					rs.getString("bairro_endereco"),
					rs.getString("cidade_endereco"),
					rs.getString("estado_endereco"),
					rs.getString("cep_endereco")
					));
		}
		
		return lista;
	}
	
	
	//metodo de consulta por codigo
	public Endereco consultarPorCodigo(int codigo)throws Exception{
		stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE cod_endereco = ?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Endereco(
					rs.getInt("cod_endereco"),
					rs.getString("logradouro_endereco"),
					rs.getString("numero_endereco"),
					rs.getString("bairro_endereco"),
					rs.getString("cidade_endereco"),
					rs.getString("estado_endereco"),
					rs.getString("cep_endereco")
					
					);
		}else {
			return new Endereco();
		}
	}
	
	//metodo que consulta por logradouro
		public List<Endereco> consultarPorLogradouro(String nome)throws Exception{
			List<Endereco> lista = new ArrayList<Endereco>();
			stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE logradouro_endereco LIKE ?");
			stmt.setString(1, "%" +nome+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Endereco(
						rs.getInt("cod_endereco"),
						rs.getString("logradouro_endereco"),
						rs.getString("numero_endereco"),
						rs.getString("bairro_endereco"),
						rs.getString("cidade_endereco"),
						rs.getString("estado_endereco"),
						rs.getString("cep_endereco")
						));
			}
			
			return lista;
		}
		
		//metodo que consulta por Bairro
		public List<Endereco> consultarPorBairro(String bairro)throws Exception{
			List<Endereco> lista = new ArrayList<Endereco>();
			stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE bairro_endereco LIKE ?");
			stmt.setString(1, "%" +bairro+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Endereco(
						rs.getInt("cod_endereco"),
						rs.getString("logradouro_endereco"),
						rs.getString("numero_endereco"),
						rs.getString("bairro_endereco"),
						rs.getString("cidade_endereco"),
						rs.getString("estado_endereco"),
						rs.getString("cep_endereco")
						));
			}
			
			return lista;
		}
		

		//metodo que consulta por Cidade
		public List<Endereco> consultarPorCidade(String cidade)throws Exception{
			List<Endereco> lista = new ArrayList<Endereco>();
			stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE cidade_endereco = ?");
			stmt.setString(1, cidade);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Endereco(
						rs.getInt("cod_endereco"),
						rs.getString("logradouro_endereco"),
						rs.getString("numero_endereco"),
						rs.getString("bairro_endereco"),
						rs.getString("cidade_endereco"),
						rs.getString("estado_endereco"),
						rs.getString("cep_endereco")
						));
			}
			
			return lista;
		}
		
		//metodo que consulta por Estado
		public List<Endereco> consultarPorEstado(String estado)throws Exception{
			List<Endereco> lista = new ArrayList<Endereco>();
			stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE estado_endereco = ?");
			stmt.setString(1, estado);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Endereco(
						rs.getInt("cod_endereco"),
						rs.getString("logradouro_endereco"),
						rs.getString("numero_endereco"),
						rs.getString("bairro_endereco"),
						rs.getString("cidade_endereco"),
						rs.getString("estado_endereco"),
						rs.getString("cep_endereco")
						));
			}
			
			return lista;
		}
		
		//metodo que consulta por Cep
		public List<Endereco> consultarPorCep(String cep)throws Exception{
			List<Endereco> lista = new ArrayList<Endereco>();
			stmt = con.prepareStatement("SELECT * FROM ENDERECO WHERE cep_endereco LIKE ?");
			stmt.setString(1, "%" + cep + "%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(new Endereco(
						rs.getInt("cod_endereco"),
						rs.getString("logradouro_endereco"),
						rs.getString("numero_endereco"),
						rs.getString("bairro_endereco"),
						rs.getString("cidade_endereco"),
						rs.getString("estado_endereco"),
						rs.getString("cep_endereco")
						));
			}
			
			return lista;
		}
		
		//metodo que atualiza o Endereco
		public String atualizaEndereco(Endereco end)throws Exception{
			stmt = con.prepareStatement("UPDATE ENDERECO SET logradouro_endereco = ?, numero_endereco = ?, bairro_endereco = ?, cidade_endereco = ?, estado_endereco = ?, cep_endereco = ? WHERE cod_endereco = ?");
			stmt.setString(1, end.getLogradouro());
			stmt.setString(2, end.getNumero());
			stmt.setString(3, end.getBairro());
			stmt.setString(4, end.getCidade());
			stmt.setString(5, end.getEstado());
			stmt.setString(7, end.getCep());
			stmt.setInt(8, end.getCodigo());
			stmt.executeUpdate();
			return "Endereço Atualizado!";
		}
		
		//metodo que deleta por cod_endereco
		public int apagar(int numero)throws Exception{
			stmt = con.prepareStatement("DELETE FROM ENDERECO WHERE cod_endereco = ?");
			stmt.setInt(1, numero);
			return stmt.executeUpdate();
		}
		
		//metodo que fecha conexão com o Banco
		public void fechar()throws Exception{
			con.close();
		}
}
