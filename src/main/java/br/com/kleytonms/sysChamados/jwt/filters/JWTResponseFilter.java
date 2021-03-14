package br.com.kleytonms.sysChamados.jwt.filters;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import br.com.kleytonms.sysChamados.dtos.LoginDTO;
import br.com.kleytonms.sysChamados.jwt.security.JWTTokenUtility;


@Provider
public class JWTResponseFilter implements ContainerResponseFilter {

	@Inject
	private JWTTokenUtility jwtTokenUtility;
	
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        if (requestContext.getProperty("auth-failed") != null) {
            Boolean failed = (Boolean) requestContext.getProperty("auth-failed");
            if (failed) {
                System.out.println("JWT auth failed. No need to return JWT token");
                return;
            }
        }
        Principal principal = requestContext.getSecurityContext().getUserPrincipal();
        if(principal==null){
        	System.out.println("Sem principal");
        	return;
        }
        List<Object> jwt = new ArrayList<Object>();
        //Usuario user = (Usuario) principal;
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(principal.getName());
        jwt.add(jwtTokenUtility.issueToken(loginDTO));
        jwt.add(requestContext.getHeaderString("Authorization").split(" ")[1]);
        responseContext.getHeaders().put("jwt", jwt);

    }
}
