package br.com.onsmarttech.butler.models.security;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissao {

	@Id
	private Long codigo;
	private String descricao;

	public Permissao() {
	}

	@Override
	public String toString() {
		return "Permissao [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
