package br.com.fiap.bo;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

public class EspecialidadeBO {

	public static String cadastroEspecialidade(Especialidade esp)throws Exception{
		
		if(esp.getNome().length()== 0 || esp.getNome().length()>60) {
			return "Nome Especialidade Inv�lido!";
		}
				
		EspecialidadeDAO dao = new EspecialidadeDAO();
		Especialidade e = dao.consultarPorCodigo(esp.getCodigo());
		if(e.getCodigo()>0) {
			dao.fechar();
			return "C�digo Especialidade j� Existe!";
		}
		
		e = dao.consultarPorNome(esp.getNome());
		if(!e.getNome().equals(null)) {
			return "Nome Especialidade j� Existe!";
		}
		
		esp.setNome(esp.getNome().toUpperCase());
		
		String resposta = dao.gravar(esp);
		dao.fechar();
		return resposta;
	}
	
	public static String atualizarEspecialidade(Especialidade esp)throws Exception {
		String resposta = "";
		EspecialidadeDAO dao = new EspecialidadeDAO();
		Especialidade e = dao.consultarPorCodigo(esp.getCodigo());
		if(e.getCodigo()>0) {
			resposta = dao.atualizaEspecialidade(esp);
		}else {
			return "Especialidade n�o existe!";
		}
		dao.fechar();
		return resposta;
	}
	
}
