package br.net.cleytoncandido.arquivar.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.net.cleytoncandido.arquivar.model.Usuario;
import br.net.cleytoncandido.arquivar.repository.Usuarios;
import br.net.cleytoncandido.arquivar.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		
		return usuarios.guardar(usuario);
	}
	
}
