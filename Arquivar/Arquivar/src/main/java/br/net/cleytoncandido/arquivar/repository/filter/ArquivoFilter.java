package br.net.cleytoncandido.arquivar.repository.filter;

import java.io.Serializable;

public class ArquivoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String nome;
	private String cpf;
	private String anoProcesso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAnoProcesso() {
		return anoProcesso;
	}

	public void setAnoProcesso(String anoProcesso) {
		this.anoProcesso = anoProcesso;
	}

}