package br.com.autoglass.pipeline_rest_assured.test.suporte.usuario;

import java.util.List;

public class Usuario {

	private boolean Ativo;
	private String Codigo;
	private String Nome;
	private String CodigoPerfil;
	private String LoginAD;
	
	public Usuario( String ativo, String codigo, String codigoPerfil,  String nome, String loginAD){
		this.Ativo = true;
		this.Codigo = codigo;
		this.CodigoPerfil = codigoPerfil;
		this.Nome = nome;
		this.LoginAD = loginAD;
		
	}
	

	public Usuario(){
		
	}


	public boolean getAtivo() {
		return Ativo;
	}


	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}


	public String getCodigo() {
		return Codigo;
	}


	public void setCodigo(String codigo) {
		Codigo = codigo;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getCodigoPerfil() {
		return CodigoPerfil;
	}


	public void setCodigoPerfil(String codigoPerfil) {
		CodigoPerfil = codigoPerfil;
	}


	public String getLoginAD() {
		return LoginAD;
	}


	public void setLoginAD(String loginAD) {
		LoginAD = loginAD;
	}
	
	public Usuario getUsuarioBD(String clausulaWhere){
		UsuarioDAO usuBD = new UsuarioDAO();
		Usuario usu1 = usuBD.getUsuario(clausulaWhere);
		return usu1;
	}


	public List<Usuario> getListaUsuarioDispositivoMovel(String codempresa) {
		UsuarioDAO usuBD = new UsuarioDAO();
		List<Usuario> usuarioLista= usuBD.getListaUsuarioDispositivoMovel(codempresa);
		return usuarioLista;
	}
}
