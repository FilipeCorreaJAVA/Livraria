package br.com.livraria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.livraria.DAO.ClienteDAO;
import br.com.livraria.DAO.entity.Cliente;


public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Cliente clientes = new Cliente();
		clientes.setNome("João da Silva");
		clientes.setBairro("Boa Vista");
		clientes.setCelular("9-8888.1234");
		clientes.setCep("50123-847");
		clientes.setCodigo(new Long("458"));
		clientes.setComplemento("Quadra 1");
		clientes.setCpf("854.417.123.78");
		clientes.setEmail("joao@gmail.com");
		clientes.setNumero(new Short("789"));
		clientes.setRg("147852");
		clientes.setRua("Rua das Flores");
		clientes.setTelefone("3453-8514");
		

		ClienteDAO clientesDAO = new ClienteDAO();
		clientesDAO.salvar(clientes);

		System.out.println("Cliente salvo com sucesso");

	}

	@Test
	@Ignore
	public void listar() {

		ClienteDAO clientesDAO = new ClienteDAO();
		List<Cliente> resultado = clientesDAO.listar();

		for (Cliente clientes : resultado) {

			System.out.println("Bairro: " + clientes.getBairro());
			System.out.println("Celular: " + clientes.getCelular());
			System.out.println("CEP: " + clientes.getCep());
			System.out.println("Complemento: " + clientes.getComplemento());
			System.out.println("CPF: " + clientes.getCpf());
			System.out.println("Email: " + clientes.getEmail());
			System.out.println("Nome do Cliente: " + clientes.getNome());
			System.out.println("RG: " + clientes.getRg());
			System.out.println("Nome da rua: " + clientes.getRua());
			System.out.println("Telefone: " + clientes.getTelefone());
			System.out.println("Número: " + clientes.getNumero());

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		ClienteDAO clientesDAO = new ClienteDAO();
		Cliente clientes = clientesDAO.buscar(codigo);

		System.out.println("Bairro: " + clientes.getBairro());
		System.out.println("Celular: " + clientes.getCelular());
		System.out.println("CEP: " + clientes.getCep());
		System.out.println("Complemento: " + clientes.getComplemento());
		System.out.println("CPF: " + clientes.getCpf());
		System.out.println("Email: " + clientes.getEmail());
		System.out.println("Nome do Cliente: " + clientes.getNome());
		System.out.println("RG: " + clientes.getRg());
		System.out.println("Nome da rua: " + clientes.getRua());
		System.out.println("Telefone: " + clientes.getTelefone());
		System.out.println("Número: " + clientes.getNumero());

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		ClienteDAO clientesDAO = new ClienteDAO();
		Cliente clientes = clientesDAO.buscar(codigo);

		clientesDAO.excluir(clientes);	
		
		System.out.println("Bairro: " + clientes.getBairro());
		System.out.println("Celular: " + clientes.getCelular());
		System.out.println("CEP: " + clientes.getCep());
		System.out.println("Complemento: " + clientes.getComplemento());
		System.out.println("CPF: " + clientes.getCpf());
		System.out.println("Email: " + clientes.getEmail());
		System.out.println("Nome do Cliente: " + clientes.getNome());
		System.out.println("RG: " + clientes.getRg());
		System.out.println("Nome da rua: " + clientes.getRua());
		System.out.println("Telefone: " + clientes.getTelefone());
		System.out.println("Número: " + clientes.getNumero());

	}

	@Test
	@Ignore
	public void editar(){
	Long codigoClientes = 4L;
	
	ClienteDAO clientesDAO = new ClienteDAO ();
	Cliente clientes = clientesDAO.buscar(codigoClientes);	
	
	System.out.println("Bairro: " + clientes.getBairro());
	System.out.println("Celular: " + clientes.getCelular());
	System.out.println("CEP: " + clientes.getCep());
	System.out.println("Complemento: " + clientes.getComplemento());
	System.out.println("CPF: " + clientes.getCpf());
	System.out.println("Email: " + clientes.getEmail());
	System.out.println("Nome do Cliente: " + clientes.getNome());
	System.out.println("RG: " + clientes.getRg());
	System.out.println("Nome da rua: " + clientes.getRua());
	System.out.println("Telefone: " + clientes.getTelefone());
	System.out.println("Número: " + clientes.getNumero());
	
	
	clientes.getNome();
	
	clientesDAO.editar(clientes);
	
	
	}
	
	
}

