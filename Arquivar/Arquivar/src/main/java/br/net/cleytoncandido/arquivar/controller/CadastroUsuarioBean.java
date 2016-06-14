package br.net.cleytoncandido.arquivar.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.net.cleytoncandido.arquivar.model.Grupo;
import br.net.cleytoncandido.arquivar.model.Usuario;
import br.net.cleytoncandido.arquivar.service.CadastroGrupoService;
import br.net.cleytoncandido.arquivar.service.CadastroUsuarioService;
import br.net.cleytoncandido.arquivar.service.NegocioException;
import br.net.cleytoncandido.arquivar.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	private Usuario usuario;

	private String senha;
	private String senha2;
	
	@Inject
	private CadastroGrupoService cadastroGrupoService;
	private List<Grupo> grupos = new ArrayList<>();
	private List<String> listaGrupos = new ArrayList<>();
	private List<String> gruposSelecionados = new ArrayList<String>();
	
	public CadastroUsuarioBean(){
		limpar();
	}
	
	@PostConstruct
	public void inicializar() {

		usuario = new Usuario();
		this.grupos = cadastroGrupoService.buscarTodos();

	}
	
	public void limpar() {
		usuario = new Usuario();
	}

	public void salvar() {
		try {
			List<Grupo> listaGruposString = new ArrayList<Grupo>();
			for (String grupo : gruposSelecionados) {
				listaGruposString.add(cadastroGrupoService.peloNome(grupo));

			}
			this.usuario.setSenha(criptografar(senha).toLowerCase());
			this.usuario.setGrupos(listaGruposString);
			this.cadastroUsuarioService.salvar(usuario);
			limpar();
			FacesUtil.addInfoMessage("Cadastro Novo Salvo com Sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}	
	
	public String criptografar(String senha) {

		MessageDigest algoritmo;
		byte messageDigest[];
		StringBuilder hexString;
		try {
			algoritmo = MessageDigest.getInstance("MD5"); // 32 letras
			messageDigest = algoritmo.digest(senha.getBytes("UTF-8"));
			hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			senha = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<String> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<String> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<String> getGruposSelecionados() {
		return gruposSelecionados;
	}

	public void setGruposSelecionados(List<String> gruposSelecionados) {
		this.gruposSelecionados = gruposSelecionados;
	}
	
	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

}