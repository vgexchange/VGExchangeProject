package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the relacionamentos_status database table.
 * 
 */
@Entity
@Table(name="relacionamentos_status")
@NamedQuery(name="StatusRelacionamento.findAll", query="SELECT r FROM StatusRelacionamento r")
public class StatusRelacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	private String descricao;

	//bi-directional many-to-one association to UsuariosRelacionamento
	@OneToMany(mappedBy="relacionamentosStatus", fetch = FetchType.LAZY)
	private List<RelacionamentoUsuario> relacionamentos;

	public StatusRelacionamento() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<RelacionamentoUsuario> getRelacionamentos() {
		return relacionamentos;
	}

	public void setRelacionamentos(List<RelacionamentoUsuario> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}

}