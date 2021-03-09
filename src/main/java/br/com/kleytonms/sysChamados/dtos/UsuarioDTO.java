package br.com.kleytonms.sysChamados.dtos;

import java.util.HashSet;
import java.util.Set;

import br.com.kleytonms.sysChamados.entidades.Chamado;

public class UsuarioDTO {

	private Long id;
	
	private String usuario;
	
	private String senha;
	
	private String nome;
	
	private String email;
	
	private Set<Chamado> chamados = new HashSet<Chamado>();
	
	public UsuarioDTO(Long id, String usuario, String senha, String nome, String email, Set<Chamado> chamados) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.chamados = chamados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(Set<Chamado> chamados) {
		this.chamados = chamados;
	}

	
}
