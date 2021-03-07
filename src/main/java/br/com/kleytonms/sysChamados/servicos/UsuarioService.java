package br.com.kleytonms.sysChamados.servicos;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.UsuarioDAO;
import br.com.kleytonms.sysChamados.entidades.Usuario;

@Stateless
public class UsuarioService {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public void criar(Usuario usuario) {
		
		usuarioDAO.cria(usuario);
		
	}

	public Usuario listar() {
		// TODO Auto-generated method stub
		return usuarioDAO.list();
	}

}
