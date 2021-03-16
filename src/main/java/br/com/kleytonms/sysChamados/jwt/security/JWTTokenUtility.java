package br.com.kleytonms.sysChamados.jwt.security;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.kleytonms.sysChamados.dtos.LoginDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
public class JWTTokenUtility {

	private static final Logger logger = Logger.getLogger(JWTTokenUtility.class.getName());

	@Inject
	private KeyProducer keyProducer;

	public String issueToken(final LoginDTO loginDTO) {
		final Date convertedDatetime = Date
				.from(LocalDateTime.now().plusHours(5)
						.atZone(ZoneId.systemDefault()).toInstant());
		final String jwtToken = Jwts.builder().setSubject(loginDTO.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(convertedDatetime)
				.signWith(SignatureAlgorithm.HS256, this.keyProducer.getKey())
				.compact();

		try {

			// Validate the token
			Jwts.parser().setSigningKey(this.keyProducer.getKey()).parseClaimsJws(jwtToken);
//			JWTTokenUtility.logger.info("#### valid token : " + jwtToken + ", key: "+this.keyProducer.getKey().hashCode());

		} catch (final Exception e) {
			JWTTokenUtility.logger.severe("#### invalid token : " + jwtToken);
		}

		return jwtToken;
	}
	
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
