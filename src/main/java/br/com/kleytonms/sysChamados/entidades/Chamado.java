package br.com.kleytonms.sysChamados.entidades;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.kleytonms.sysChamados.enums.Status;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
	
//	@XmlTransient
//	@OneToMany(mappedBy = "chamado", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	private Set<Comentario> comentarios = new HashSet<Comentario>();

	
	
//	public Chamado() {
//	}

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

//	public Set<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(Set<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
