package br.com.kleytonms.sysChamados.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.dtos.UsuarioDTO;
import br.com.kleytonms.sysChamados.exceptions.DBException;
import br.com.kleytonms.sysChamados.servicos.UsuarioService;

@Path("usuario")
public class UsuarioREST {

	@Inject
	private UsuarioService usuarioService;
	
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listar() {
		try {
			List<UsuarioDTO> usuarios = usuarioService.listarTodos();
		
			return Response.ok(usuarios).build();
		} catch (DBException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response criar(UsuarioDTO usuario) {
		try {
			usuarioService.criaOuAtualiza(usuario);
			return Response.status(201).build();
		} catch (Exception | DBException e) {
			return Response.status(500).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response atualiza(UsuarioDTO usuario, @PathParam(value = "id") Long id) {
		try {
			usuario.setId(id);
			UsuarioDTO usuarioUpToDate = usuarioService.criaOuAtualiza(usuario);
			usuarioUpToDate.setSenha(null);
			return Response.ok(usuarioUpToDate).build();
		} catch (DBException e) {
			return Response.status(500).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@JWTTokenNeeded
	public Response apaga(@PathParam(value = "id") Long id) {
		
		try {
			usuarioService.apaga(id);
		} catch (DBException e) {
			return Response.status(500).build();
		}
		
		return Response.ok().build();
	}
	
	/*
	 * private List<Usuario> carregaCollection(List<Usuario> usuarios, boolean
	 * objCompleto){ if(objCompleto) { List<Usuario> list = new
	 * ArrayList<Usuario>(); for (Usuario usuario : usuarios) { list.add(usuario); }
	 * return list; }else { for (Usuario usuario : usuarios) {
	 * usuario.setChamados(null);
	 * 
	 * } return usuarios; }
	 * 
	 * 
	 * 
	 * }
	 */
	
}
