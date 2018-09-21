package br.com.fiap.teste;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.bo.EspecialidadeBO;
import br.com.fiap.excecao.Excecao;



public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EspecialidadeBO bo = new EspecialidadeBO();
			Especialidade esp = new Especialidade();
			
			esp.setCodigo(5);
			//esp.setNome("Vamos");
			
		 Especialidade espe =  bo.excluirPorCodigoEspecialidade(getCodigo());
			System.out.println(espe.getCodigo());
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(Excecao.tratarExcecao(ex));
		}
	}

}
