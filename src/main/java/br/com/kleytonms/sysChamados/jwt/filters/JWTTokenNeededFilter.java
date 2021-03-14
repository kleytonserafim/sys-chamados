package br.com.kleytonms.sysChamados.jwt.filters;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.kleytonms.sysChamados.anotacoes.JWTTokenNeeded;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.jwt.security.KeyProducer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

	private static final Logger logger = Logger.getLogger(JWTTokenNeededFilter.class.getName());

	@Inject
	private KeyProducer keyProducer;

	private String validate(final String token) throws JwtException {
		String subject = null;
		final Key key = this.keyProducer.getKey();

		
		
			Jws<Claims> claims;
			claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
		

		try {
			System.out.println("asfdas");
			subject = claims.getBody().getSubject();
		} catch (final JwtException e) {
			
			JWTTokenNeededFilter.logger.severe(e.getMessage());
			throw e;
		}
		return subject;
	}


	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {

		final String authHeaderVal = requestContext.getHeaderString("Authorization");

		if(authHeaderVal == null) {
			requestContext.setProperty("auth-failed", true);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			return;
		}

		//        consume JWT i.e. execute signature validation
		if (authHeaderVal.startsWith("Bearer")) {
			try {
				final String token = authHeaderVal.split(" ")[1];
				this.validate(token);
				requestContext.getSecurityContext();
				final Jws<Claims> claims = Jwts.parser().setSigningKey(this.keyProducer.getKey()).parseClaimsJws(token);
				final Usuario usuario = new Usuario();
				usuario.setNome(claims.getBody().getSubject());
				
				
				/*
				 * final String roles = (String) claims.getBody().get("roles"); final String[]
				 * splittedRoles = roles.split(","); final Set<String> rolesSet = new
				 * HashSet<String>(); for(final String rol : splittedRoles) {
				 * rolesSet.add(rol.trim()); } usuario.setRoles(rolesSet); final RoleSecurity
				 * secContext = new RoleSecurity(usuario, true);
				 * 
				 * //Seteamos el contexto de seguridad
				 * requestContext.setSecurityContext(secContext);
				 */
				
				
				/*if (subject != null) {
                    requestContext.setSecurityContext(new SecurityContext() {
                        @Override
                        public Principal getUserPrincipal() {
                            return new Principal() {
                                @Override
                                public String getName() {
                                    return subject;
                                }
                            };
                        }

                        @Override
                        public boolean isUserInRole(String role) {
                            return securityContext.isUserInRole(role);
                        }

                        @Override
                        public boolean isSecure() {
                            return securityContext.isSecure();
                        }

                        @Override
                        public String getAuthenticationScheme() {
                            return securityContext.getAuthenticationScheme();
                        }
                    });
                }*/
			} catch (final JwtException ex) {
				System.out.println("JWT validation failed");

				requestContext.setProperty("auth-failed", true);
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());

			}

		} else {
			System.out.println("No JWT token !");
			requestContext.setProperty("auth-failed", true);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}

}