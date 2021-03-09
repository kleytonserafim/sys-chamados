package br.com.kleytonms.sysChamados.dtos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import br.com.kleytonms.sysChamados.entidades.Comentario;
import br.com.kleytonms.sysChamados.entidades.Usuario;
import br.com.kleytonms.sysChamados.enums.Status;

public class ChamadoDTO {

	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDateTime inclusao;
	
	private LocalDateTime conclusao;
	
	private Usuario usuarioNome;
	
	private Status status;
	
	private Set<Comentario> comentarios = new HashSet<Comentario>();

	public ChamadoDTO(Long id, String titulo, String descricao, LocalDateTime inclusao, LocalDateTime conclusao,
			Usuario usuarioNome, Status status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.inclusao = inclusao;
		this.conclusao = conclusao;
		this.usuarioNome = usuarioNome;
		this.status = status;
	}
	
	public ChamadoDTO() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getInclusao() {
		return inclusao;
	}

	public void setInclusao(LocalDateTime inclusao) {
		this.inclusao = inclusao;
	}

	public LocalDateTime getConclusao() {
		return conclusao;
	}

	public void setConclusao(LocalDateTime conclusao) {
		this.conclusao = conclusao;
	}

	public Usuario getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(Usuario usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
}
