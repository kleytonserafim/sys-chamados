package br.com.kleytonms.sysChamados.rest;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.dtos.ChamadoDTO;
import br.com.kleytonms.sysChamados.enums.Status;
import br.com.kleytonms.sysChamados.exceptions.DBException;
import br.com.kleytonms.sysChamados.jwt.security.JWTTokenUtility;
import br.com.kleytonms.sysChamados.servicos.ChamadoService;
import br.com.kleytonms.sysChamados.servicos.UsuarioService;

@Path("chamado/")
public class ChamadoREST {

	@Inject
	private ChamadoService chamadoService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private JWTTokenUtility jwt;
	
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listar() {
		return Response.ok(chamadoService.listaTodos()).build();
		//return Response.ok(Status.ABERTO).build();
	}
	
	@GET
	@Path("{id}/")
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response listById(@PathParam("id") Long id, @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
		try {
			return Response.ok(chamadoService.listById(id)).build();
		} catch (DBException e) {
			return Response.status(500).build();
		}
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response criar(ChamadoDTO chamado, @HeaderParam(HttpHeaders.AUTHORIZATION) String auth) {
		chamado.setInclusao(LocalDateTime.now());
		chamado.setUsuarioCriador(usuarioService.findByLogin(jwt.validate(auth.split(" ")[1])));
		chamadoService.criaOuAtualiza(chamado.convertToEntity());
		return Response.status(201).build();
	}
	
	@PUT
	@Path("/fecha/{id}/")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response fechaChamado(@PathParam(value = "id") Long id) {
		ChamadoDTO chamadoUpToDate = new ChamadoDTO(chamadoService.fecha(id));
		return Response.ok(chamadoUpToDate).build();
	}
	
	@PUT
	@Path("/alteraStatus/{id}/")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public Response alteraStatusChamado(@PathParam(value = "id") Long id, @HeaderParam(HttpHeaders.AUTHORIZATION) String auth, Status status) {
		
		
		ChamadoDTO chamadoUpToDate = chamadoService.alteraStatus(id, jwt.validate(auth.split(" ")[1]), status);
		return Response.ok(chamadoUpToDate).build();
	}
	
//	@PUT
//	@Path("{id}/")
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	@Produces(value = MediaType.APPLICATION_JSON)
//	@JWTTokenNeeded
//	public Response atualiza(ChamadoDTO chamado, @PathParam(value = "id") Long id) {
//		chamado.setId(id);
//		ChamadoDTO chamadoUpToDate = new ChamadoDTO(chamadoService.criaOuAtualiza(chamado.convertToEntity()));
//		return Response.ok(chamadoUpToDate).build();
//	}
	
	
	
//	@DELETE
//	@Path("{id}/")
//	@JWTTokenNeeded
//	public Response apaga(@PathParam(value = "id") Long id) {
//		try {
//			chamadoService.apaga(id);
//		} catch (DBException e) {
//			return Response.status(500).build();
//		}
//		return Response.ok().build();
//	}
}
