package br.com.livraria.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.livraria.DAO.entity.Cliente;
import br.com.livraria.util.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {

	@SuppressWarnings("unchecked")
	public List<Cliente> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cliente.class);

			consulta.addOrder(Order.asc("nome"));
			List<Cliente> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
