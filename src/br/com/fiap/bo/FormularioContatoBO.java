package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.FormularioContato;
import br.com.fiap.dao.FormularioContatoDAO;

public class FormularioContatoBO {
	
	private FormularioContato f;
	private FormularioContatoDAO dao;
	private String resposta;
	private List<FormularioContato> lista;
	
	public FormularioContatoBO()throws Exception{
		f = new FormularioContato();
		dao = new FormularioContatoDAO();
		lista = new ArrayList<FormularioContato>();
	}

	public String verificacaoInicial(FormularioContato form)throws Exception{
		
		if(form.getNome() == null || form.getNome() == "" || form.getNome().length() > 60) {
			return "Nome Inválido!";
		}
		
		if(form.getEmail() == null || form.getEmail() == "" || form.getEmail().length() > 60) {
			return "Email Inválido!";
		}
		
		if(form.getMensagem() == null || form.getMensagem() == "" || form.getMensagem().length() > 1500) {
			return "Mensagem Inválido!";
		}
		
		if(form.getTipo() == null || form.getTipo() == "" || form.getTipo().length() > 50) {
			return "Tipo Inválido!";
		}
		
		return "OK";
	}
	
	public String verificaExiste(FormularioContato form)throws Exception{
		resposta = "VERIFICADO";
		
		f = dao.consultarPorCodigo(form.getCodigo());
		
		if(f.getCodigo()>0) {
			dao.fechar();
			return "Código Formulario de Contato já Existe!";
		}
		
		return resposta;
	}
	
	public  String cadastroFormularioContato(FormularioContato form)throws Exception{
		
		resposta = verificacaoInicial(form);
		
		if(resposta.equals("OK")) {
			resposta = verificaExiste(form);
		}	
		
		form.setNome(form.getNome().toUpperCase());
		form.setMensagem(form.getMensagem().toUpperCase());
		form.setTipo(form.getTipo().toUpperCase());
	
		
		if(resposta.equals("VERIFICADO")) {
			resposta = dao.gravar(form);
			dao.fechar();
		}
		
		return resposta;
	}
	
	public  FormularioContato pesquisarPorCodigoFormularioContato(int codigo)throws Exception{
		if(codigo < 1) {
			return new FormularioContato();
		}
		
		f = dao.consultarPorCodigo(codigo);
		dao.fechar();
		return f;
	}
	
	public List<FormularioContato> pesquisarPorNomeFormularioContato(String nome)throws Exception{ 
		if(nome == null || nome == "" || nome.length() > 60) {
			return lista;
		}
		
		lista = dao.consultarPorNome(nome);
		dao.fechar();
		return lista;
	}
	
	public List<FormularioContato> pesquisarPorEmailFormularioContato(String email)throws Exception{
		if(email == null || email == "" || email.length() > 60) {
			return lista;
		}
		
		lista = dao.consultarPorEmail(email);
		dao.fechar();
		return lista;
		
	}
	
	public List<FormularioContato> pesquisarPorMensagemFormularioContato(String mensagem)throws Exception{
		if(mensagem == null ||  mensagem == "" || mensagem.length() > 1500) {
			return lista;
		}
		
		lista  = dao.consultarPorMensagem(mensagem);
		dao.fechar();
		return lista;
	}
	
	public List<FormularioContato> pesquisarPorTipoFormularioContato(String tipo)throws Exception{
		if(tipo == null || tipo == "" || tipo.length() > 50) {
			return lista;
		}
		
		lista = dao.consultarPorTipo(tipo);
		dao.fechar();
		return lista;
	}

	public int excluirPorCodigoFormularioContato(int numero)throws Exception{
		if(numero < 1) {
			return 0;
		}
		
		int x =dao.apagar(numero);
		dao.fechar();
		return x;
	}
}
