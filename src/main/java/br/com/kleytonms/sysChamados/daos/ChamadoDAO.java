package br.com.kleytonms.sysChamados.daos;

import javax.ejb.Stateless;

import br.com.kleytonms.sysChamados.entidades.Chamado;

@Stateless
public class ChamadoDAO extends GenericDAO<Chamado, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ChamadoDAO() {
		super(Chamado.class);
	}

}
