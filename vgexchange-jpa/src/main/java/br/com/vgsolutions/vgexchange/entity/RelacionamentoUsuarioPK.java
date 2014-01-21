package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios_relacionamentos database table.
 * 
 */
@Embeddable
public class RelacionamentoUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String usuarios_emailA;

	@Column(insertable=false, updatable=false)
	private String usuarios_emailB;

	public RelacionamentoUsuarioPK() {
	}
	public String getUsuarios_emailA() {
		return this.usuarios_emailA;
	}
	public void setUsuarios_emailA(String usuarios_emailA) {
		this.usuarios_emailA = usuarios_emailA;
	}
	public String getUsuarios_emailB() {
		return this.usuarios_emailB;
	}
	public void setUsuarios_emailB(String usuarios_emailB) {
		this.usuarios_emailB = usuarios_emailB;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelacionamentoUsuarioPK)) {
			return false;
		}
		RelacionamentoUsuarioPK castOther = (RelacionamentoUsuarioPK)other;
		return 
			this.usuarios_emailA.equals(castOther.usuarios_emailA)
			&& this.usuarios_emailB.equals(castOther.usuarios_emailB);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuarios_emailA.hashCode();
		hash = hash * prime + this.usuarios_emailB.hashCode();
		
		return hash;
	}
}