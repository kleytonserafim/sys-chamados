package br.com.kleytonms.sysChamados.jwt.security;

import java.security.Key;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import io.jsonwebtoken.impl.crypto.MacProvider;

@Singleton
public class KeyProducer {

	private Key key;

	@PostConstruct
	private void produce() {
		key = MacProvider.generateKey();
	}

	public Key getKey() {
		return key;
	}
	
	
}
