package br.com.kleytonms.sysChamados.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.kleytonms.sysChamados.enums.Status;

@Entity
public class Chamado extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -945306287075629422L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDateTime inclusao;
	
	private LocalDateTime conclusao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuarioCriador;
	
	@Enumerated(EnumType.STRING)
	private Status status;

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

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
