package br.com.kleytonms.sysChamados.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.kleytonms.sysChamados.entidades.Comentario;

@JsonInclude(value = Include.NON_NULL)
public class ComentarioDTO {
	
private Long id;
	
	private ChamadoDTO chamado;
	
	private String detalhe;
	
	private UsuarioDTO usuario;
	
	private LocalDateTime inclusao;
	
	public ComentarioDTO() {
		
	}

	public ComentarioDTO(Long id, ChamadoDTO chamado, String detalhe, UsuarioDTO usuario, LocalDateTime inclusao) {
		super();
		this.id = id;
		this.chamado = chamado;
		this.detalhe = detalhe;
		this.usuario = usuario;
		this.inclusao = inclusao;
	}
	
	public ComentarioDTO(Comentario comentario) {
		
		if(comentario.getId() != null) this.id = comentario.getId();
		if(comentario.getId() != null) this.chamado = new ChamadoDTO(comentario.getChamado());
		if(comentario.getDetalhe() != null) this.detalhe = comentario.getDetalhe();
		if(comentario.getUsuario() != null) this.usuario = getUsuario();
		if(comentario.getInclusao() != null) this.inclusao = getInclusao();
	}
	
	public Comentario convertToEntity() {
		Comentario comentario = new Comentario();
		
		if(this.id != null) comentario.setId(id);
		if(this.chamado != null) comentario.setChamado(chamado.convertToEntity());
		if(this.detalhe != null) comentario.setDetalhe(detalhe);
		if(this.usuario != null) comentario.setUsuario(usuario.convertToEntity());
		if(this.inclusao != null) comentario.setInclusao(inclusao);
		
		return comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChamadoDTO getChamado() {
		return chamado;
	}

	public void setChamado(ChamadoDTO chamado) {
		this.chamado = chamado;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getInclusao() {
		return inclusao;
	}

	public void setInclusao(LocalDateTime inclusao) {
		this.inclusao = inclusao;
	}

}
