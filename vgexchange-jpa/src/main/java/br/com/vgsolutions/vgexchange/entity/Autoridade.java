package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autoridades database table.
 * 
 */
@Entity
@Table(name="autoridades")
@NamedQuery(name="Autoridade.findAll", query="SELECT a FROM Autoridade a")
public class Autoridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	private String descricao;

	//bi-directional many-to-one association to UsuariosAutoridade
	@OneToMany(mappedBy="autoridade", fetch=FetchType.LAZY)
	private List<AutoridadeUsuario> usuariosAutoridades;

	public Autoridade() {
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

	public List<AutoridadeUsuario> getUsuariosAutoridades() {
		return this.usuariosAutoridades;
	}

	public void setUsuariosAutoridades(List<AutoridadeUsuario> usuariosAutoridades) {
		this.usuariosAutoridades = usuariosAutoridades;
	}

	public AutoridadeUsuario addUsuariosAutoridade(AutoridadeUsuario usuariosAutoridade) {
		getUsuariosAutoridades().add(usuariosAutoridade);
		usuariosAutoridade.setAutoridade(this);

		return usuariosAutoridade;
	}

	public AutoridadeUsuario removeUsuariosAutoridade(AutoridadeUsuario usuariosAutoridade) {
		getUsuariosAutoridades().remove(usuariosAutoridade);
		usuariosAutoridade.setAutoridade(null);

		return usuariosAutoridade;
	}

}