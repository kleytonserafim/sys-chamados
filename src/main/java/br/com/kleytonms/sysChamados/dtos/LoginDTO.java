package br.com.kleytonms.sysChamados.dtos;

import java.util.Set;

public class LoginDTO {

	private Long id;

	private String username;

	private String nomeUsuario;

	private String token;

	private String nome;

	private String email;

	private Set<String> roles;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(final String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return this.roles;
	}

	public void setRoles(final Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + this.id + ", username=" + this.username + ", nomeUsuario=" + this.nomeUsuario + ", token=" + this.token
				+ ", nome=" + this.nome + ", email=" + this.email + "]";
	}

}
