package br.com.kleytonms.sysChamados.daos;

import javax.ejb.Stateless;

import br.com.kleytonms.sysChamados.entidades.Comentario;

@Stateless
public class ComentarioDAO extends GenericDAO<Comentario, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ComentarioDAO() {
		super(Comentario.class);
		// TODO Auto-generated constructor stub
	}

}
