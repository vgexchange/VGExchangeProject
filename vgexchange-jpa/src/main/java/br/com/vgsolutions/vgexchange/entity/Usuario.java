package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

//teste jonas
/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String senha;

	//bi-directional one-to-one association to UsuariosAutoridade
	@OneToOne(mappedBy="usuario", fetch=FetchType.LAZY)
	private AutoridadeUsuario usuariosAutoridade;

	//bi-directional many-to-many association to Console
	@ManyToMany
	@JoinTable(
		name="usuarios_consoles"
		, joinColumns={
			@JoinColumn(name="usuarios_email")
			}
		, inverseJoinColumns={
			@JoinColumn(name="consoles_codigo")
			}
		)
	private Collection<Console> consoles = new LinkedHashSet<Console>();

	//bi-directional one-to-one association to Usuarios_dadosPrincipai
	@OneToOne(mappedBy="usuario", fetch=FetchType.LAZY)
	private DadosPrincipaisUsuario dadosPrincipais;

	//bi-directional many-to-many association to Jogo
	@ManyToMany
	@JoinTable(
		name="usuarios_jogos"
		, joinColumns={
			@JoinColumn(name="usuarios_email")
			}
		, inverseJoinColumns={
			@JoinColumn(name="jogos_codigo")
			}
		)
	private Collection<Jogo> jogos = new LinkedHashSet<Jogo>();

	//bi-directional many-to-one association to UsuariosRelacionamento
	@OneToMany(mappedBy="usuarioA")
	private Collection<RelacionamentoUsuario> relacionamentosA = new LinkedHashSet<RelacionamentoUsuario>();

	//bi-directional many-to-one association to UsuariosRelacionamento
	@OneToMany(mappedBy="usuarioB")
	private Collection<RelacionamentoUsuario> relacionamentosB = new LinkedHashSet<RelacionamentoUsuario>();

	public Usuario() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public AutoridadeUsuario getUsuariosAutoridade() {
		return this.usuariosAutoridade;
	}

	public void setUsuariosAutoridade(AutoridadeUsuario usuariosAutoridade) {
		this.usuariosAutoridade = usuariosAutoridade;
	}

	public Collection<Console> getConsoles() {
		return this.consoles;
	}

	public void setConsoles(Collection<Console> consoles) {
		this.consoles = consoles;
	}

	public DadosPrincipaisUsuario getDadosPrincipais() {
		return dadosPrincipais;
	}

	public void setDadosPrincipais(DadosPrincipaisUsuario dadosPrincipais) {
		this.dadosPrincipais = dadosPrincipais;
	}

	public Collection<Jogo> getJogos() {
		return this.jogos;
	}

	public void setJogos(Collection<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Collection<RelacionamentoUsuario> getRelacionamentosA() {
		return relacionamentosA;
	}

	public void setRelacionamentosA(Collection<RelacionamentoUsuario> relacionamentosA) {
		this.relacionamentosA = relacionamentosA;
	}

	public Collection<RelacionamentoUsuario> getRelacionamentosB() {
		return relacionamentosB;
	}

	public void setRelacionamentosB(List<RelacionamentoUsuario> relacionamentosB) {
		this.relacionamentosB = relacionamentosB;
	}

	public RelacionamentoUsuario addRelacionamentoA(RelacionamentoUsuario relacionamentoA) {
		getRelacionamentosA().add(relacionamentoA);
		relacionamentoA.setUsuarioA(this);

		return relacionamentoA;
	}

	public RelacionamentoUsuario removeRelacionamentoA(RelacionamentoUsuario relacionamentoA) {
		getRelacionamentosA().remove(relacionamentoA);
		relacionamentoA.setUsuarioA(null);

		return relacionamentoA;
	}

	public RelacionamentoUsuario addRelacionamentoB(RelacionamentoUsuario relacionamentoB) {
		getRelacionamentosB().add(relacionamentoB);
		relacionamentoB.setUsuarioB(this);

		return relacionamentoB;
	}

	public RelacionamentoUsuario removeRelacionamentoB(RelacionamentoUsuario relacionamentosB) {
		getRelacionamentosB().remove(relacionamentosB);
		relacionamentosB.setUsuarioB(null);

		return relacionamentosB;
	}

}