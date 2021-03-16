package br.com.kleytonms.sysChamados.jwt.security;

import java.security.Key;

import javax.inject.Inject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JWTTokenUtils {
	
	@Inject
	private KeyProducer keyProducer;
	
	public String validate(final String token) throws JwtException {
		String subject = null;
		final Key key = this.keyProducer.getKey();
			Jws<Claims> claims;
			claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
		try {
			subject = claims.getBody().getSubject();
		} catch (final JwtException e) {
			
			throw e;
		}
		return subject;
	}

}
