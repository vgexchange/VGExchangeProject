package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jogos_generos database table.
 * 
 */
@Entity
@Table(name="jogos_generos")
@NamedQuery(name="JogosGenero.findAll", query="SELECT j FROM JogosGenero j")
public class JogosGenero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	//bi-directional many-to-one association to Jogo
	@OneToMany(mappedBy="genero")
	private List<Jogo> jogos;

	public JogosGenero() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Jogo> getJogos() {
		return this.jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Jogo addJogo(Jogo jogo) {
		getJogos().add(jogo);
		jogo.setGenero(this);

		return jogo;
	}

	public Jogo removeJogo(Jogo jogo) {
		getJogos().remove(jogo);
		jogo.setGenero(null);

		return jogo;
	}

}