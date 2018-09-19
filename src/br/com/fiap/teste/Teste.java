package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Clinica;
import br.com.fiap.dao.ClinicaDAO;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClinicaDAO dao = new ClinicaDAO();
			String resultado = new String();
			Clinica c = new Clinica();
			dao.gravar(c.getCodigo(), c.getNome(), c.getEmail(), c.getCnpj(), c.getSite(), c.getHorario(), 'N', 0, c.getTelefone(),  2, 3);
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
