package br.com.kleytonms.sysChamados.daos;

import javax.ejb.Stateless;

import br.com.kleytonms.sysChamados.entidades.Usuario;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long>{

	private static final long serialVersionUID = 1L;

	protected UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	

}
