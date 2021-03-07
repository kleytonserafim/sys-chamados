package br.com.kleytonms.sysChamados.daos;

import javax.ejb.Stateless;

import br.com.kleytonms.sysChamados.entidades.Usuario;

@Stateless
public class UsuarioDAO extends BaseDAO{

	

	public void cria(Usuario usuario) {
		
		entityManager.persist(usuario);
		
	}

	public Usuario list() {
		
		return entityManager.find(Usuario.class, 1);
	}
	
}
