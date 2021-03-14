package br.com.kleytonms.sysChamados.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.entidades.Comentario;
import br.com.kleytonms.sysChamados.servicos.ComentarioService;

@Path("comentario/")
public class ComentarioREST {
	
	
	@Inject
	private ComentarioService comentarioService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listar() {
		return Response.ok(comentarioService.listaTodos()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response criar(Comentario comentario) {
			System.out.println(comentarioService.criaOuAtualiza(comentario));
			return Response.status(201).build();		
	}
		

}
