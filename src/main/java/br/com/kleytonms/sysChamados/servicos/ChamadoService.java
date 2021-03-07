package br.com.kleytonms.sysChamados.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.ChamadoDAO;
import br.com.kleytonms.sysChamados.entidades.Chamado;
import br.com.kleytonms.sysChamados.exceptions.DBException;

@Stateless
public class ChamadoService {

	@Inject
	private ChamadoDAO chamadoDAO;
	
	public Chamado criaOuAtualiza(Chamado chamado) {
		try {
			return chamadoDAO.createOrUpdate(chamado);
		} catch (DBException e) {
			return null;
		}
	}
	
	public List<Chamado> listaTodos(){
		try {
			return chamadoDAO.findAll();
		} catch (DBException e) {
			return null;
		}
	}
}
