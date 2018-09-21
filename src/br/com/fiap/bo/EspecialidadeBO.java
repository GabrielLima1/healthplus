package br.com.fiap.bo;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

public class EspecialidadeBO {
	
	public static String verificacaoInicial(Especialidade esp)throws Exception{
		
		if(esp.getNome() ==  null || esp.getNome() ==  "" || esp.getNome().length()>60) {
			return "Nome Especialidade Inválido!";
		}
		
		return "OK";
	}

	public static String cadastroEspecialidade(Especialidade esp)throws Exception{
		
		String resposta = verificacaoInicial(esp);
		
		if(resposta.equals("OK")){
				
				EspecialidadeDAO dao = new EspecialidadeDAO();
				Especialidade e = dao.consultarPorCodigo(esp.getCodigo());
				
				if(e.getCodigo()>0) {
					dao.fechar();
					return "Código Especialidade já Existe!";
				}

				e = dao.consultarPorNome(esp.getNome());
				if(e.getNome() != null) {
					return "Nome Especialidade já Existe!";
				}
				
				resposta = "PASSOU";
		}
		
		esp.setNome(esp.getNome().toUpperCase());
		
		EspecialidadeDAO dao = new EspecialidadeDAO();
		
		if(resposta.equals("PASSOU")) {
			resposta = dao.gravar(esp);
			dao.fechar();
			
		}
		return resposta;
	}
	
	public static String atualizarEspecialidade(Especialidade esp)throws Exception {
		
		String resposta = "";
		
		if(esp.getCodigo() == 0) {
			return "Código Usúario Inválido!";
		}
		
		EspecialidadeDAO dao = new EspecialidadeDAO();
		Especialidade e = dao.consultarPorCodigo(esp.getCodigo());
		
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
	
	
	public static Especialidade pesquisaPorCodigoEspecialidade(int codigo)throws Exception{
		if(codigo < 1) {
			return new Especialidade();
		}
		
		EspecialidadeDAO dao = new EspecialidadeDAO();
		Especialidade esp = dao.consultarPorCodigo(codigo);
		dao.fechar();
		return esp;
	}
	
	public static Especialidade pesquisaPorNomeEspecialidade(String nome)throws Exception{
		if(nome.length() < 1) {
			return new Especialidade();
		}
		
		EspecialidadeDAO dao = new EspecialidadeDAO();
		Especialidade espe = dao.consultarPorNome(nome.toUpperCase());
		dao.fechar();
		return espe;
		}
	
	public static int excluirPorCodigoEspecialidade(int codigo)throws Exception{
		if(codigo < 1) {
			return 0;
		}
		
		EspecialidadeDAO dao = new EspecialidadeDAO();
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
}

