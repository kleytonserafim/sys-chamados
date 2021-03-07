package br.com.kleytonms.sysChamados.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kleytonms.sysChamados.entidades.Chamado;
import br.com.kleytonms.sysChamados.servicos.ChamadoService;

@Path("chamado/")
public class ChamadoREST {

	@Inject
	private ChamadoService chamadoService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listar() {
		return Response.ok(chamadoService.listaTodos()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response criar(Chamado chamado) {
			System.out.println(chamadoService.criaOuAtualiza(chamado));
			return Response.status(201).build();
		
		
	}
	
}
