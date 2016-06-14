package br.net.cleytoncandido.arquivar.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.net.cleytoncandido.arquivar.model.Grupo;
import br.net.cleytoncandido.arquivar.repository.Grupos;
import br.net.cleytoncandido.arquivar.util.jpa.Transactional;

public class CadastroGrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Grupos grupos;

	@Transactional
	public void salvar(Grupo grupo) throws NegocioException {

		this.grupos.salvar(grupo);
	}

	public List<Grupo> buscarTodos() {
		return grupos.buscarTodos();
	}
	
	public Grupo peloCodigo(Long id){
		return this.grupos.buscarPeloCodigo(id);
	}
	
	public Grupo peloNome(String id){
		return this.grupos.peloNome(id);
	}
	
}
