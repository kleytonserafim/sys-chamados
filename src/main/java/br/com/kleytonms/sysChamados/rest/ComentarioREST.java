package br.com.kleytonms.sysChamados.rest;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.dtos.ComentarioDTO;
import br.com.kleytonms.sysChamados.jwt.security.JWTTokenUtility;
import br.com.kleytonms.sysChamados.servicos.ComentarioService;
import br.com.kleytonms.sysChamados.servicos.UsuarioService;

@Path("comentario/")
public class ComentarioREST {
	
	
	@Inject
	private ComentarioService comentarioService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private JWTTokenUtility jwt;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listar() {
		return Response.ok(comentarioService.listaTodos()).build();
	}
	
	@GET
	@Path("{id}/")
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listById(@PathParam("id") Long id) {
		return Response.ok(comentarioService.listById(id)).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response criar(ComentarioDTO comentario, @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
		comentario.setInclusao(LocalDateTime.now());
		comentario.setUsuario(usuarioService.findByLogin(jwt.validate(auth.split(" ")[1])));
		comentarioService.criaOuAtualiza(comentario);
		return Response.status(201).build();		
	}

}
