package br.net.cleytoncandido.arquivar.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.net.cleytoncandido.arquivar.model.Arquivo;
import br.net.cleytoncandido.arquivar.repository.Arquivos;
import br.net.cleytoncandido.arquivar.util.jpa.Transactional;

public class CadastroArquivoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Arquivos arquivos;
	
	@Transactional
	public Arquivo salvar(Arquivo arquivo) {
		
		return arquivos.guardar(arquivo);
	}
	
}
