package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jogos database table.
 * 
 */
@Entity
@Table(name="jogos")
@NamedQuery(name="Jogo.findAll", query="SELECT j FROM Jogo j")
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to JogosGenero
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="generosJogos_codigo")
	private JogosGenero genero;

	//bi-directional many-to-one association to JogosEdicoe
	@OneToMany(mappedBy="jogo")
	private List<EdicaoJogo> edicoes;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="jogos")
	private List<Usuario> usuarios;

	public Jogo() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public JogosGenero getGenero() {
		return genero;
	}

	public void setGenero(JogosGenero genero) {
		this.genero = genero;
	}

	public List<EdicaoJogo> getEdicoes() {
		return edicoes;
	}

	public void setEdicoes(List<EdicaoJogo> edicoes) {
		this.edicoes = edicoes;
	}

	public EdicaoJogo addEdicao(EdicaoJogo edicao) {
		getEdicoes().add(edicao);
		edicao.setJogo(this);

		return edicao;
	}

	public EdicaoJogo removeEdicao(EdicaoJogo edicao) {
		getEdicoes().remove(edicao);
		edicao.setJogo(null);

		return edicao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}