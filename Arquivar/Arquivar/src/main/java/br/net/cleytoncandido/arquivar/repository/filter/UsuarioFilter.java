package br.net.cleytoncandido.arquivar.repository.filter;

import java.io.Serializable;

public class UsuarioFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}