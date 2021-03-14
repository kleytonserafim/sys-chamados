package br.com.kleytonms.sysChamados.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.UsuarioDAO;
import br.com.kleytonms.sysChamados.dtos.UsuarioDTO;
import br.com.kleytonms.sysChamados.encrypt.PHPass;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class UsuarioService {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public static final PHPass phpass = new PHPass(8);
	
	public UsuarioDTO findById(Long id) {
		try {
			return new UsuarioDTO(usuarioDAO.find(id));
		} catch (DBException e) {
			return null;
		}
	}
	
	public UsuarioDTO criaOuAtualiza(UsuarioDTO usuario) throws DBException {
		return new UsuarioDTO(usuarioDAO.createOrUpdate(usuario.convertToEntity()));
	}
	
	public void apaga(Long id) throws DBException {
		usuarioDAO.delete(id);
	}

	public List<UsuarioDTO> listarTodos() throws DBException {
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		ArrayList<UsuarioDTO> dtos = new ArrayList<UsuarioDTO>();
		
		for (Usuario usuario : usuarios) {
			
			dtos.add(new UsuarioDTO(usuario.getId(), usuario.getUsuario(),usuario.getNome(), usuario.getEmail(), usuario.getChamados()));
		}
		return dtos;
	}

}
