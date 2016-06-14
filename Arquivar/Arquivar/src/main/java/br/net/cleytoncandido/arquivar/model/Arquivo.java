package br.net.cleytoncandido.arquivar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="arquivo")
public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String anoProcesso;
	private String armario;
	private Integer prateleira;
	private String caixaArquivo;
	private boolean insinerado;
	private boolean digitalizado;
	

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@Column(nullable = false, length = 14)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotBlank
	@Size(max = 4)
	@Column(nullable = false, length = 4)
	public String getAnoProcesso() {
		return anoProcesso;
	}

	public void setAnoProcesso(String anoProcesso) {
		this.anoProcesso = anoProcesso;
	}
	
	@NotBlank
	@Size(max = 4)
	@Column(nullable = false, length = 4)
	public String getArmario() {
		return armario;
	}

	public void setArmario(String armario) {
		this.armario = armario;
	}
	
	@Column(nullable = false, length = 3)
	public Integer getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(Integer prateleira) {
		this.prateleira = prateleira;
	}
	
	@NotBlank
	@Size(max = 4)
	@Column(nullable = false, length = 4)
	public String getCaixaArquivo() {
		return caixaArquivo;
	}

	public void setCaixaArquivo(String caixaArquivo) {
		this.caixaArquivo = caixaArquivo;
	}

	public boolean isInsinerado() {
		return insinerado;
	}

	public void setInsinerado(boolean insinerado) {
		this.insinerado = insinerado;
	}

	public boolean isDigitalizado() {
		return digitalizado;
	}

	public void setDigitalizado(boolean digitalizado) {
		this.digitalizado = digitalizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquivo other = (Arquivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	


}