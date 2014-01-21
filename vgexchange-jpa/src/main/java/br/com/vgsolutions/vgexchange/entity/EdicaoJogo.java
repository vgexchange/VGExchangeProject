package br.com.vgsolutions.vgexchange.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jogos_edicoes database table.
 * 
 */
@Entity
@Table(name="jogos_edicoes")
@NamedQuery(name="EdicaoJogo.findAll", query="SELECT j FROM EdicaoJogo j")
public class EdicaoJogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long codigo;

	private String descricao;

	//bi-directional many-to-one association to Jogo
	@ManyToOne
	@JoinColumn(name="jogos_codigo")
	private Jogo jogo;

	public EdicaoJogo() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Jogo getJogo() {
		return this.jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

}