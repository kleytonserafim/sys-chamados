package br.com.kleytonms.sysChamados.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.kleytonms.sysChamados.entidades.Chamado;
import br.com.kleytonms.sysChamados.enums.Status;

@JsonInclude(value = Include.NON_NULL)
public class ChamadoDTO {

	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDateTime inclusao;
	
	private LocalDateTime conclusao;
	
	private UsuarioDTO usuarioCriador;
	
	private Status status;
	
	private List<ComentarioDTO> comentarios;

	public ChamadoDTO(Long id, String titulo, String descricao, LocalDateTime inclusao, LocalDateTime conclusao,
			UsuarioDTO usuarioCriador, Status status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.inclusao = inclusao;
		this.conclusao = conclusao;
		this.usuarioCriador = usuarioCriador;
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

	public UsuarioDTO getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(UsuarioDTO usuarioNome) {
		this.usuarioCriador = usuarioNome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	
	public ChamadoDTO(Chamado chamado){
		
		if(chamado.getId() != null) this.id = chamado.getId();
		if(chamado.getTitulo() != null) this.titulo = chamado.getTitulo();
		if(chamado.getDescricao() != null) this.descricao = chamado.getDescricao();
		if(chamado.getInclusao() != null) this.inclusao = chamado.getInclusao();
		if(chamado.getConclusao() != null) this.conclusao = chamado.getConclusao();
		if(chamado.getUsuarioCriador() != null) this.usuarioCriador = new UsuarioDTO(chamado.getUsuarioCriador());
		if(chamado.getStatus() != null) this.status = chamado.getStatus();
	}
	
	public Chamado convertToEntity() {
		Chamado chamado = new Chamado();
		if(this.id != null) chamado.setId(this.id);
		if(this.titulo != null) chamado.setTitulo(this.titulo);
		if(this.descricao != null) chamado.setDescricao(this.descricao);
		if(this.inclusao != null) chamado.setInclusao(this.inclusao);
		if(this.conclusao != null) chamado.setConclusao(this.conclusao);
		if(this.usuarioCriador != null) chamado.setUsuarioCriador(this.usuarioCriador.convertToEntity());
		if(this.status != null) chamado.setStatus(this.status);
		
		
		return chamado;
	}
	
	
}
