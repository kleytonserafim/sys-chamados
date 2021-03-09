package br.com.kleytonms.sysChamados.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.kleytonms.sysChamados.daos.ChamadoDAO;
import br.com.kleytonms.sysChamados.dtos.ChamadoDTO;
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

	public List<Chamado> listaTodos() {
		try {
			List<Chamado> chamados = chamadoDAO.findAll();
			
//			List<ChamadoDTO> chamadosDTO = new ArrayList<ChamadoDTO>();
//			
//			ModelMapper mapper = new ModelMapper();
//			for (Chamado chamado : chamados) {
//				chamadosDTO.add(mapper.map(chamado, ChamadoDTO.class));
//			}

			return chamados;
		} catch (DBException e) {
			return null;
		}
	}
}
