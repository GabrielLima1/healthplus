package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Clinica;
import br.com.fiap.dao.ClinicaDAO;

public class ClinicaBO {
		
		private Clinica c;
		private ClinicaDAO dao;
		private String resposta;
		private List<Clinica> lista;
		
		public ClinicaBO() throws Exception{
			c = new Clinica();
			dao = new ClinicaDAO();
			lista = new ArrayList<Clinica>();
		}
		
		public String verificaCampos(Clinica cli)throws Exception{
			resposta = "OK";
			
			if (cli.getNome() == null || cli.getNome() == "" || cli.getNome().length() > 60)
				return "Nome Clinica Inv�lido!";
			if (cli.getEmail() == null || cli.getEmail() == "" || cli.getEmail().length()>60)
				return "Email Clinica Inv�lido!";
			if (cli.getCnpj() == null || cli.getCnpj() == "" || cli.getCnpj().length()>20)
				return "Cnpj Clinica Inv�lido!";
			if (cli.getSite() == null || cli.getSite() == "" || cli.getSite().length()>60)
				return "Site Clinica Inv�lido!";
			if (cli.getHorario() == null || cli.getHorario() == "" || cli.getHorario().length()>255)
				return "Horario Clinica Inv�lido!";
			if (cli.getTelefone() == null || cli.getTelefone() == "" || cli.getTelefone().length() != 14)
				return "Telefone Clinica Inv�lido!";
			
			cli.setNome(cli.getNome().toUpperCase());
			
			return resposta;
		}
		
		public String verificaExiste(Clinica cli)throws Exception{
			resposta = "VERIFICADO";
			
			c = dao.consultarPorCodigo(cli.getCodigo());
			if (c.getCodigo() > 0) {
				dao.fechar();
				return "Clinica J� Existe!";
			}
			
			c = dao.consultarPorCnpj(cli.getCnpj());
			if (c.getCnpj() != null) {
				dao.fechar();
				return "CNPJ da Clinica J� Existe!";
			}
			
			return resposta;
		}
		
		public String cadastrarClinica(Clinica cli)throws Exception{
			
			 resposta = verificaCampos(cli);
			
			if(resposta.equals("OK")) {
				resposta = verificaExiste(cli);
			}
			
			if(resposta.equals("VERIFICADO")) {
				resposta = dao.gravar(cli);
				dao.fechar();
			}
			
			return resposta;

	}

		public String atualizarClinica(Clinica cli)throws Exception{
			resposta = verificaCampos(cli);
			
			c = dao.consultarPorCodigo(cli.getCodigo());
			
			if(c.getCodigo() > 0) {
				if(c.getCnpj().equals(c.getCnpj())) {
					resposta = dao.atualizarClinica(cli);
					dao.fechar();
				}else {
					return "CNPJ Inv�lido!";
				}
			}else {
				dao.fechar();
				return "C�digo Clinica Inv�lido!";
			}
			
			dao.fechar();
			return resposta;
		}

		public String desativarClinica(Clinica cli)throws Exception{
			c = dao.consultarPorCodigo(cli.getCodigo());
			
			if(c.getCodigo() > 0 && c.getDelete().equals("N")) {
				resposta = dao.deletar(cli);
			}else {
				resposta = "Erro ao Desativar Clinica!";
			}
			
			dao.fechar();
			return resposta;
		}
}
