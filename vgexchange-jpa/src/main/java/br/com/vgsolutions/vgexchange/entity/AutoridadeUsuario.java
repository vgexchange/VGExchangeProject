package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_autoridades database table.
 * 
 */
@Entity
@Table(name="usuarios_autoridades")
@NamedQuery(name="AutoridadeUsuario.findAll", query="SELECT u FROM AutoridadeUsuario u")
public class AutoridadeUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuarios_email")
	private String emailUsuario;

//	@Id
	//bi-directional one-to-one association to Usuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_email")
	private Usuario usuario;

	//bi-directional many-to-one association to Autoridade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="autoridades_codigo")
	private Autoridade autoridade;

	public AutoridadeUsuario() {
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Autoridade getAutoridade() {
		return this.autoridade;
	}

	public void setAutoridade(Autoridade autoridade) {
		this.autoridade = autoridade;
	}

}