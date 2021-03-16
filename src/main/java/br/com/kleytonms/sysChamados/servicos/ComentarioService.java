package br.com.kleytonms.sysChamados.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.ComentarioDAO;
import br.com.kleytonms.sysChamados.dtos.ComentarioDTO;
import br.com.kleytonms.sysChamados.entidades.Comentario;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class ComentarioService {

	@Inject
	private ComentarioDAO comentarioDAO;
	
	
	
	public ComentarioDTO criaOuAtualiza(ComentarioDTO comentario) {
		
		System.out.println(comentario);
		
		try {
			Comentario comentarioInserido = comentarioDAO.createOrUpdate(comentario.convertToEntity());
			return new ComentarioDTO(comentarioInserido);
		} catch (DBException e) {
			return null;
		}
	}
	
	
	public List<ComentarioDTO> listaTodos(){
		try {
			List<Comentario> comentarios = comentarioDAO.findAll();
			List<ComentarioDTO> comentariosDTO = new ArrayList<ComentarioDTO>();
			comentarios.stream().forEachOrdered(comentario -> comentariosDTO.add(new ComentarioDTO(comentario)));

			return comentariosDTO;
		} catch (DBException e) {
			return null;
		}
	}

	public ComentarioDTO listById(Long id) {
		// TODO Auto-generated method stub
		try {
			return new ComentarioDTO(comentarioDAO.find(id));
		} catch (DBException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
}
