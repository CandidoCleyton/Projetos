package br.net.cleytoncandido.arquivar.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.net.cleytoncandido.arquivar.model.Arquivo;
import br.net.cleytoncandido.arquivar.repository.filter.ArquivoFilter;
import br.net.cleytoncandido.arquivar.service.NegocioException;
import br.net.cleytoncandido.arquivar.util.jpa.Transactional;

public class Arquivos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Arquivo guardar(Arquivo arquivo) {
		return manager.merge(arquivo);
	}
	
	@Transactional
	public void remover(Arquivo arquivo) {
		try {
			arquivo = porId(arquivo.getId());
			manager.remove(arquivo);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Arquivo não pode ser excluído.");
		}
	}
	
	public Arquivo porCpf(String cpf) {
		try {
			return manager.createQuery("from Arquivo where upper(cpf) = :cpf", Arquivo.class)
				.setParameter("cpf", cpf.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Arquivo porAnoProcesso(String anoProcesso) {
		try {
			return manager.createQuery("from Arquivo where upper(anoProcesso) = :anoProcesso", Arquivo.class)
				.setParameter("anoProcesso", anoProcesso.toUpperCase())
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Arquivo> filtrados(ArquivoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Arquivo.class);

		if (StringUtils.isNotBlank(filtro.getCpf())) {
			criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
		}
				
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(filtro.getAnoProcesso())) {
			criteria.add(Restrictions.eq("anoProcesso", filtro.getAnoProcesso()));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Arquivo porId(Long id) {
		return manager.find(Arquivo.class, id);
	}

	public List<Arquivo> porNome(String nome) {
		return this.manager.createQuery("from Arquivo where upper(nome) like :nome", Arquivo.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}	
	
}
