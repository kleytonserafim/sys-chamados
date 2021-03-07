package br.com.kleytonms.sysChamados.entidades;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -516280191519144611L;

	public abstract Long getId();
	
}
