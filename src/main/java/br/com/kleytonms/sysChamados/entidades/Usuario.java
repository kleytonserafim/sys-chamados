package br.com.kleytonms.sysChamados.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario extends BaseEntity{
	
	private static final long serialVersionUID = 1146295637220971679L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	
	private String senha;
	
	private String nome;
	
	private String email;
	
//	@XmlTransient
//	@OneToMany(mappedBy = "usuarioCriador", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	private Set<Chamado> chamados = new HashSet<Chamado>();
	
	
	
//	public Usuario() {
//		
//	}
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
	
	
//	public Set<Chamado> getChamados() {
//		return chamados;
//	}
//	public void setChamados(Set<Chamado> chamados) {
//		this.chamados = chamados;
//	}
	@Override
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
