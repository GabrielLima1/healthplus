package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.PlanoSaude;
import br.com.fiap.dao.PlanoSaudeDAO;

public class PlanoSaudeBO {
	
	private PlanoSaude p;
	private PlanoSaudeDAO dao;
	private String resposta;
	private List<PlanoSaude> lista;
	
	public PlanoSaudeBO()throws Exception{
		p = new PlanoSaude();
		dao = new PlanoSaudeDAO();
		lista = new ArrayList<PlanoSaude>();
		}
	
	public String verificacaoInicial(PlanoSaude plan)throws Exception{
		
		if(plan.getNome() == null || plan.getNome() == "" || plan.getNome().length() > 60) {
			return "Nome Plano de Saúde Inválido!";
		}
		
		if(plan.getModalidade() == null || plan.getModalidade() == "" || plan.getModalidade().length() > 30) {
			return "Modalidade Plano de Saúde Inválido!";
		}
		
		return "OK";
	}
	
	public String verificaExiste(PlanoSaude plan)throws Exception{
		resposta = "VERIFICADO";
		
		p = dao.consultarPorCodigo(plan.getCodigo());
		if(p.getCodigo()>0) {
			dao.fechar();
			return "Código Plano de Saúde já Existe!";
		}
		
		return resposta;
	}
	
	public String cadastrarPlanoSaude(PlanoSaude plan)throws Exception{
		
		String resposta = verificacaoInicial(plan);
		
		if(resposta.equals("OK")) {
			resposta = verificaExiste(plan);				
		}
		
		plan.setNome(plan.getNome().toUpperCase());
		plan.setModalidade(plan.getModalidade().toUpperCase());
		
		if(resposta.equals("PASSOU")) {
			resposta = dao.gravar(plan);
			dao.fechar();
		}
		
		return resposta;
	}
	
	public String atualizarPlanoSaude(PlanoSaude plan)throws Exception{
		
		String resposta = "";
		
		if(p.getCodigo() == 0) {
			return "Código Plano de Saúde já Existe!";
		}
		
		p = dao.consultarPorCodigo(plan.getCodigo());
		
		if(p.getCodigo()>0) {
			resposta = verificacaoInicial(plan);
			
			if(resposta.equals("OK")) {
				resposta = dao.atualizaPlanoSaude(plan);
				dao.fechar();
				}
			}
		else {
				return "Código Plano Saúde Inválido!";
			}
		return resposta;
	}
			
	public PlanoSaude pesquisarPorCodigoPlanoSaude(int codigo)throws Exception{
		if(codigo < 1) {
			return new PlanoSaude();
		}
		
		p = dao.consultarPorCodigo(codigo);
		dao.fechar();
		return p;
	}
	
	public List<PlanoSaude> pesquisarPorNomePlanoSaude(String nome)throws Exception{
		if(nome == null || nome == "" || nome.length() > 60) {
			return lista;
		}
		
		lista = dao.consultarPorNome(nome);
		dao.fechar();
		return lista;
	}
	
	public List<PlanoSaude> pesquisarPorModalidadePlanoSaude(String modalidade)throws Exception{		
		if(modalidade.length() > 30) {
			return lista;
		}
		
		lista = dao.ConsultarPorModalidade(modalidade);
		dao.fechar();
		return lista;
	}
	
	public int excluitPorCodigoPlanoSaude(int codigo)throws Exception{
		if(codigo < 1) {
			return 0;
		}
		
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
}
