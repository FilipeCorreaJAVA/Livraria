package br.com.livraria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.livraria.DAO.VendaDAO;
import br.com.livraria.DAO.entity.Venda;

public class VendaDAOTest {


	@Test
	@Ignore
	public void salvar() {
		Venda vendas = new Venda();
		vendas.setHorario(new Date()); 
		vendas.setPrecoTotal(new BigDecimal("100.00"));
		VendaDAO vendasDAO = new VendaDAO();
		vendasDAO.salvar(vendas);
		System.out.println("Venda realizada com sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendasDAO = new VendaDAO();
		List<Venda> resultado = vendasDAO.listar();
		for (Venda Vendas : resultado) {
			System.out.println("Hora da venda: " + Vendas.getHorario()); 
			System.out.println("Valor total: " + Vendas.getPrecoTotal());
			System.out.println("Nome do cliente: " + Vendas.getCliente());
		}
	}
	

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 7L;
		VendaDAO vendasDAO = new VendaDAO();
		Venda vendas = vendasDAO.buscar(codigo);
		System.out.println("Hora da venda: " + vendas.getHorario()); 
		System.out.println("Valor total: " + vendas.getPrecoTotal());
		System.out.println("Nome do cliente: " + vendas.getCliente()); 
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 8L;
		VendaDAO vendasDAO = new VendaDAO();
		Venda vendas = vendasDAO.buscar(codigo);
		vendasDAO.excluir(vendas);	
		System.out.println("Hora da venda: " + vendas.getHorario()); 
		System.out.println("Valor total: " + vendas.getPrecoTotal());
		System.out.println("Nome do cliente: " + vendas.getCliente());
	}

	@Test
	@Ignore
	public void editar(){
	Long codigoVendas = 7L;
	VendaDAO vendasDAO = new VendaDAO ();
	Venda vendas = vendasDAO.buscar(codigoVendas);	
	System.out.println("Hora da venda: " + vendas.getHorario()); 
	System.out.println("Valor total: " + vendas.getPrecoTotal());
	System.out.println("Nome do cliente: " + vendas.getCliente());
	vendas.setCodigo((long) 1);
	vendasDAO.editar(vendas);
	
	}
}
