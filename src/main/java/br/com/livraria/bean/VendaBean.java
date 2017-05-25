package br.com.livraria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import br.com.livraria.DAO.ClienteDAO;
import br.com.livraria.DAO.LivroDAO;
import br.com.livraria.DAO.VendaDAO;
import br.com.livraria.DAO.entity.Cliente;
import br.com.livraria.DAO.entity.ItemVenda;
import br.com.livraria.DAO.entity.Livro;
import br.com.livraria.DAO.entity.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private Venda venda;

	private List<Livro> livros;
	private List<ItemVenda> itensVenda;
	private List<Cliente> clientes;
	private List<Venda> vendas;

	@PostConstruct
	public void novo() {
		try {
			venda = new Venda();
			venda.setPrecoTotal(new BigDecimal("0.00"));
			venda.setHorario(new Date());
			LivroDAO livroDAO = new LivroDAO();
			livros = livroDAO.listar();
			itensVenda = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}

	public void adicionar(ActionEvent evento) {
		Livro livro = (Livro) evento.getComponent().getAttributes().get("livroSelecionado");
		int achou = -1;
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getLivro().equals(livro)) {
				achou = posicao;
			}
		}

		if (achou < 0) {
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setPrecoParcial(livro.getPreco());
			itemVenda.setLivro(livro);
			itemVenda.setQuantidade(new Short("1"));
			itensVenda.add(itemVenda);
		} else {
			ItemVenda itemVenda = itensVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1 + ""));
			itemVenda.setPrecoParcial(livro.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		}

		calcular();
	}

	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes().get("itemSelecionado");
		int achou = -1;
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			if (itensVenda.get(posicao).getLivro().equals(itemVenda.getLivro())) {
				achou = posicao;
			}
		}
		if (achou > -1) {
			itensVenda.remove(achou);
		}
		calcular();
	}

	public void calcular() {
		venda.setPrecoTotal(new BigDecimal("0.00"));
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			ItemVenda itemVenda = itensVenda.get(posicao);
			venda.setPrecoTotal(venda.getPrecoTotal().add(itemVenda.getPrecoParcial()));
		}
	}

	public void finalizar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar finalizar a venda");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			if (venda.getPrecoTotal().signum() == 0) {
				Messages.addGlobalError("Informe pelo menos um item para a venda");
				return;
			}
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda, itensVenda);
			novo();
			Messages.addGlobalInfo("Venda realizada com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a venda");
			erro.printStackTrace();
		}
	}

	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		vendas = vendaDAO.listar();
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
