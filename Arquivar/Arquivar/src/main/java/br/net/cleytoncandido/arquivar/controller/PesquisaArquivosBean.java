package br.net.cleytoncandido.arquivar.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.net.cleytoncandido.arquivar.model.Arquivo;
import br.net.cleytoncandido.arquivar.repository.Arquivos;
import br.net.cleytoncandido.arquivar.repository.filter.ArquivoFilter;
import br.net.cleytoncandido.arquivar.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaArquivosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Arquivos arquivos;
	
	private ArquivoFilter filtro;
	private List<Arquivo> arquivosFiltrados;
	
	private Arquivo arquivoSelecionado;
	
	public PesquisaArquivosBean() {
		filtro = new ArquivoFilter();
	}
	
	public void excluir() {
		arquivos.remover(arquivoSelecionado);
		arquivosFiltrados.remove(arquivoSelecionado);
		
		FacesUtil.addInfoMessage("Arquivo " + arquivoSelecionado.getId() 
				+ " excluído com sucesso.");
	}
	
	public void pesquisar() {
		arquivosFiltrados = arquivos.filtrados(filtro);
	}
	
	public List<Arquivo> getArquivosFiltrados() {
		return arquivosFiltrados;
	}

	public ArquivoFilter getFiltro() {
		return filtro;
	}

	public Arquivo getArquivoSelecionado() {
		return arquivoSelecionado;
	}

	public void setArquivoSelecionado(Arquivo arquivoSelecionado) {
		this.arquivoSelecionado = arquivoSelecionado;
	}
	
}