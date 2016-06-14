package br.net.cleytoncandido.arquivar.controller;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.net.cleytoncandido.arquivar.model.Arquivo;
import br.net.cleytoncandido.arquivar.service.CadastroArquivoService;
import br.net.cleytoncandido.arquivar.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroArquivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Inject
	private CadastroArquivoService cadastroArquivoService;
	
	private Arquivo arquivo;
	
	public CadastroArquivoBean() {
		limpar();
	}
	
	public void inicializar() {
		
	}	
	
	private void limpar() {
		arquivo = new Arquivo();
	}
	
	public void salvar() {
		this.arquivo = cadastroArquivoService.salvar(this.arquivo);
		limpar();
		
		FacesUtil.addInfoMessage("Arquivo salvo com sucesso!");
	}

	public Arquivo getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
	public boolean isEditando() {
		return this.arquivo.getId() != null;
	}

}