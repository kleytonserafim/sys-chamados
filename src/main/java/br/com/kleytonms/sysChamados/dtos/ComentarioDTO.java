package br.com.kleytonms.sysChamados.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
