package br.com.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import br.com.livraria.DAO.LivroDAO;
import br.com.livraria.DAO.entity.Livro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LivroBean implements Serializable {

	private Livro livro;
	private List<Livro> livros;

	@PostConstruct
	public void listar() {
		try {
			LivroDAO livroDAO = new LivroDAO();
			livros = livroDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar os Livros");
			erro.printStackTrace();
		}
	}

	public void novo() {
		livro = new Livro();
	}

	public void salvar() {
		try {
			LivroDAO livroDAO = new LivroDAO();
			livroDAO.merge(livro);
			livro = new Livro();
			livros = livroDAO.listar();
			Messages.addGlobalInfo("Livro salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Livro");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			livro = (Livro) evento.getComponent().getAttributes().get("livroSelecionado");
			LivroDAO livroDAO = new LivroDAO();
			livroDAO.excluir(livro);
			livros = livroDAO.listar();
			Messages.addGlobalInfo("Livro removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Livro");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		livro = (Livro) evento.getComponent().getAttributes().get("livroSelecionado");
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}