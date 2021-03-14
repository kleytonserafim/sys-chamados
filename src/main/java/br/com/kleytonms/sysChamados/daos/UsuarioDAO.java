package br.com.kleytonms.sysChamados.daos;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.kleytonms.sysChamados.entidades.Usuario;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long>{

	private static final long serialVersionUID = 1L;

	protected UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuarioPorEmail(String login) {
		try {
			return entityManager.createNamedQuery("findByEmail", Usuario.class)
					.setParameter("email", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Usuario getUsuarioPorLogin(String login) {
		try {
			return entityManager.createNamedQuery("findByUsuario", Usuario.class)
					.setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	

}
