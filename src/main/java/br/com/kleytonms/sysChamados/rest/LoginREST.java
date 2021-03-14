package br.com.kleytonms.sysChamados.rest;

import java.io.Serializable;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.dtos.Login;
import br.com.kleytonms.sysChamados.dtos.LoginDTO;
import br.com.kleytonms.sysChamados.jwt.security.JWTTokenUtility;
import br.com.kleytonms.sysChamados.servicos.LoginService;

@Path("login")
public class LoginREST implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginService loginService;

	@Inject
	private JWTTokenUtility jwtTokenUtility;

	/**
	 *
	 * @param token
	 * @throws BusinessException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logar(final Login login) throws LoginException {
		try {
			final LoginDTO dto = this.loginService.login(login.getUsername(), login.getPassword());

			// Issue a token for the user
			final String token = this.jwtTokenUtility.issueToken(dto);
			dto.setToken(token);
			// Return the token on the response
			return Response.accepted(dto).header("Authorization", "Bearer " + token).build();

		} catch (final Exception e) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}

	@POST
	@Path("/logout")
	@Produces({ "application/json" })
	@JWTTokenNeeded
	public Response logout() throws Exception {
		return Response.ok().build();
	}
}
