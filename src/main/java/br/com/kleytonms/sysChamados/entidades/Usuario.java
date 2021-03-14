package br.com.kleytonms.sysChamados.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = {
                       @NamedQuery(name = "findByUsuario", 
                    		query = "SELECT u FROM Usuario u where u.usuario = :login"
                    		),
                       @NamedQuery(name = "findByEmail", 
                       		query = "SELECT u FROM Usuario u where u.email = :email"
                       		)
                       }
)
public class Usuario extends BaseEntity{
	
	private static final long serialVersionUID = 1146295637220971679L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,
			nullable = false)
	private String usuario;
	
	@Column(nullable = false)
	private String senha;
	
	private String nome;
	
	@Column(unique = true,
			nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "usuarioCriador", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonbTransient
	private List<Chamado> chamados = new ArrayList<Chamado>();
	
	
	
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
	
	public List<Chamado> getChamados() {
		return chamados;
	}
	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
