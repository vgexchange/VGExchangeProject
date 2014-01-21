package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuarios_relacionamentos database table.
 * 
 */
@Entity
@Table(name="usuarios_relacionamentos")
@NamedQuery(name="RelacionamentoUsuario.findAll", query="SELECT u FROM RelacionamentoUsuario u")
public class RelacionamentoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RelacionamentoUsuarioPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAceiteBloqueio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConvite;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_emailA", insertable=false, updatable=false)
	private Usuario usuarioA;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_emailB", insertable=false, updatable=false)
	private Usuario usuarioB;

	//bi-directional many-to-one association to RelacionamentosStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="relacionamentos_status_codigo")
	private StatusRelacionamento relacionamentosStatus;

	public RelacionamentoUsuario() {
	}

	public RelacionamentoUsuarioPK getId() {
		return this.id;
	}

	public void setId(RelacionamentoUsuarioPK id) {
		this.id = id;
	}

	public Date getDataAceiteBloqueio() {
		return this.dataAceiteBloqueio;
	}

	public void setDataAceiteBloqueio(Date dataAceiteBloqueio) {
		this.dataAceiteBloqueio = dataAceiteBloqueio;
	}

	public Date getDataConvite() {
		return this.dataConvite;
	}

	public void setDataConvite(Date dataConvite) {
		this.dataConvite = dataConvite;
	}

	public Usuario getUsuarioA() {
		return usuarioA;
	}

	public void setUsuarioA(Usuario usuarioA) {
		this.usuarioA = usuarioA;
	}

	public Usuario getUsuarioB() {
		return usuarioB;
	}

	public void setUsuarioB(Usuario usuarioB) {
		this.usuarioB = usuarioB;
	}

	public StatusRelacionamento getRelacionamentosStatus() {
		return this.relacionamentosStatus;
	}

	public void setRelacionamentosStatus(StatusRelacionamento relacionamentosStatus) {
		this.relacionamentosStatus = relacionamentosStatus;
	}

}