package br.com.kleytonms.sysChamados.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.UsuarioDAO;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class UsuarioService {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public Usuario criaOuAtualiza(Usuario usuario) throws DBException {
		
		return usuarioDAO.createOrUpdate(usuario);
		
	}
	
	public void apaga(Long id) throws DBException {
		usuarioDAO.delete(id);
	}

	public List<Usuario> listarTodos() throws DBException {
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		
		
		return usuarios;
	}

}
