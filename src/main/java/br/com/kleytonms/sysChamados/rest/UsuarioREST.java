package br.com.kleytonms.sysChamados.rest;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.servicos.UsuarioService;

@Path("usuario")
public class UsuarioREST {

	@Inject
	private UsuarioService usuarioService;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listar() {
		return Response.ok(usuarioService.listar()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response criar(Usuario usuario) {
		try {
			usuarioService.criar(usuario);
			return Response.status(201).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
	}
	
}
