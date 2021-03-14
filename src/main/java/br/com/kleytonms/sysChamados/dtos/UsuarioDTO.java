package br.com.kleytonms.sysChamados.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.kleytonms.sysChamados.entidades.Chamado;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.servicos.UsuarioService;

@JsonInclude(value = Include.NON_NULL)
public class UsuarioDTO {

	private Long id;

	private String usuario;

	private String senha;

	private String nome;

	private String email;

	private List<ChamadoDTO> chamados;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {

		this.id = usuario.getId();
		this.usuario = usuario.getUsuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		// this.chamados = usuario.getChamados();

	}

	public UsuarioDTO(Long id, String usuario, String senha, String nome, String email, List<ChamadoDTO> chamados) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.chamados = chamados;
	}

	public UsuarioDTO(Long id, String usuario, String nome, String email) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
	}

	public UsuarioDTO(Long id, String usuario, String nome, String email, List<Chamado> chamados) {
		super();

		List<ChamadoDTO> dtos = new ArrayList<ChamadoDTO>();

		chamados.stream().forEachOrdered(chamado -> dtos.add(new ChamadoDTO(chamado)));
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
		this.chamados = dtos;
	}
	
	public Usuario convertToEntity() {
		Usuario user = new Usuario();
		if(this.id != null) user.setId(this.id);
		user.setUsuario(this.usuario);
		user.setSenha(UsuarioService.phpass.HashPassword(this.senha));
		user.setNome(this.nome);
		user.setEmail(this.email);
		return user;
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

	public List<ChamadoDTO> getChamados() {
		return chamados;
	}

	public void setChamados(List<ChamadoDTO> chamados) {
		this.chamados = chamados;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", usuario=" + usuario + ", senha=" + senha + ", nome=" + nome + ", email="
				+ email + ", chamados=" + chamados + "]";
	}
	

}
