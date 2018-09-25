package br.com.fiap.bo;


import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

public class EspecialidadeBO {
	
	private Especialidade e;
	private EspecialidadeDAO dao;
	private String resposta;
	
	public EspecialidadeBO()throws Exception{
		e = new Especialidade();
		dao = new EspecialidadeDAO();
	}
	
	public String verificacaoInicial(Especialidade esp)throws Exception{
		
		if(esp.getNome() ==  null || esp.getNome() ==  "" || esp.getNome().length()>60) {
			return "Nome Especialidade Inválido!";
		}
		
		return "OK";
	}

	public String verificaExiste(Especialidade esp)throws Exception{
		resposta = "VERIFICADO";
		
		e = dao.consultarPorCodigo(esp.getCodigo());
		if(e.getCodigo()>0) {
			dao.fechar();
			return "Código Especialidade já Existe!";
		}

		e = dao.consultarPorNome(esp.getNome());
		if(e.getNome() != null) {
			dao.fechar();
			return "Nome Especialidade já Existe!";
		}
		
		return resposta;
	}
	
	public String cadastroEspecialidade(Especialidade esp)throws Exception{
		
		 resposta = verificacaoInicial(esp);
		
		if(resposta.equals("OK")){
				resposta = verificaExiste(esp);
		}
		
		esp.setNome(esp.getNome().toUpperCase());
		
		if(resposta.equals("VERIFICADO")) {
			resposta = dao.gravar(esp);
			dao.fechar();
			
		}
		return resposta;
	}
	
	public String atualizarEspecialidade(Especialidade esp)throws Exception {
		
		resposta = "";
		
		if(e.getCodigo() == 0) {
			return "Código Usúario Inválido!";
		}
		
		e = dao.consultarPorCodigo(esp.getCodigo());
		
		if(e.getCodigo()>0) {
			resposta = verificacaoInicial(esp);
			
			if(resposta.equals("OK")) {
				resposta = dao.atualizaEspecialidade(esp);
				dao.fechar();
			}		
			
		}else {
			return "Código Inválido!";
		}
		return resposta;
				
	}
	
	
	public Especialidade pesquisaPorCodigoEspecialidade(int codigo)throws Exception{
		if(codigo < 1) {
			return new Especialidade();
		}
		
		e = dao.consultarPorCodigo(codigo);
		dao.fechar();
		return e;
	}
	
	public Especialidade pesquisaPorNomeEspecialidade(String nome)throws Exception{
		if(nome.length() < 1) {
			return new Especialidade();
		}
		
		e = dao.consultarPorNome(nome.toUpperCase());
		dao.fechar();
		return e;
		}
	
	public int excluirPorCodigoEspecialidade(int codigo)throws Exception{
		if(codigo < 1) {
			return 0;
		}
		
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
}

