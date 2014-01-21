package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the usuarios_dadosPrincipais database table.
 * 
 */
@Entity
@Table(name="usuarios_dadosPrincipais")
@NamedQuery(name="DadosPrincipaisUsuario.findAll", query="SELECT u FROM DadosPrincipaisUsuario u")
public class DadosPrincipaisUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuarios_email")
	private String usuariosEmail;

//	@Id
	//bi-directional one-to-one association to Usuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_email")
	private Usuario usuario;
	
	private byte[] aceitaMalaDireta;

	private String apelido;

	private String dataCadastro;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	private String dataUltimoAcesso;

	private String nome;

	private String sobreNome;

	public DadosPrincipaisUsuario() {
	}

	public byte[] getAceitaMalaDireta() {
		return this.aceitaMalaDireta;
	}

	public void setAceitaMalaDireta(byte[] aceitaMalaDireta) {
		this.aceitaMalaDireta = aceitaMalaDireta;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataUltimoAcesso() {
		return this.dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(String dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return this.sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}