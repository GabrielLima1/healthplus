package br.com.fiap.teste;


import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.PlanoSaude;
import br.com.fiap.bo.PlanoSaudeBO;
import br.com.fiap.excecao.Excecao;



public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<PlanoSaude> lista =  new ArrayList<PlanoSaude>();
			PlanoSaudeBO bo = new PlanoSaudeBO();
			PlanoSaude plan = new PlanoSaude();
			
			plan.setCodigo(3);
			//plan.setNome("");
			plan.setModalidade("Puro");
			
			lista =  bo.pesquisarPorNomePlanoSaude(plan.getNome());
			for(PlanoSaude p: lista) {
				System.out.println(p.getNome());
			}
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(Excecao.tratarExcecao(ex));
		}
	}

}
