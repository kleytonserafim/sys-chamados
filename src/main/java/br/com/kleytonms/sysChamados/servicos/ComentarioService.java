package br.com.kleytonms.sysChamados.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.ComentarioDAO;
import br.com.kleytonms.sysChamados.entidades.Comentario;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class ComentarioService {

	@Inject
	private ComentarioDAO comentarioDAO;
	
	
	
	public Comentario criaOuAtualiza(Comentario comentario) {
		
		System.out.println(comentario);
		
		try {
			Comentario comentarioInserido = comentarioDAO.createOrUpdate(comentario);
			return comentarioInserido;
		} catch (DBException e) {
			return null;
		}
	}
	
	public List<Comentario> listaTodos(){
		try {
			return comentarioDAO.findAll();
		} catch (DBException e) {
			return null;
		}
	}
	
}
