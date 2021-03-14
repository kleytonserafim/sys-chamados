package br.com.kleytonms.sysChamados.servicos;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.daos.ChamadoDAO;
import br.com.kleytonms.sysChamados.dtos.ChamadoDTO;
import br.com.kleytonms.sysChamados.entidades.Chamado;
import br.com.kleytonms.sysChamados.enums.Status;
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

	public List<Chamado> listaTodos() {
		try {
			List<Chamado> chamados = chamadoDAO.findAll();
			
			return chamados;
		} catch (DBException e) {
			return null;
		}
	}

	public void apaga(Long id) throws DBException{
		chamadoDAO.delete(id);
	}

	public Chamado fecha(Long id) {
		Chamado chamado;
		try {
			chamado = chamadoDAO.find(id);
			chamado.setConclusao(LocalDateTime.now());
			chamado.setStatus(Status.FECHADO);
			return chamado;
			
		} catch (DBException e) {
			return null;
		}
		
		
	}

	public ChamadoDTO listById(Long id) throws DBException {
		return new ChamadoDTO(chamadoDAO.find(id));
	}
}
