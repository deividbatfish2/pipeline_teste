package br.com.autoglass.apiTest.pipeline_rest_assured.test.suporte.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.autoglass.apiTest.pipeline_rest_assured.test.util.ConnectionFactory;

public class UsuarioDAO {

	 private Connection connection;
	
	public UsuarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void getUsuarioLista(){
		
	}
	
	public Usuario getUsuario(String clausulaWhere){
		String sql = "SELECT CASE WHEN IDTSTATUS = 'A' THEN 'true' ElSE 'false' END "
					+ "IDTSTATUS, NOMLOGIN, CODUSUARIO, NOMCOMPLETO, CODPERFIL, NOMLOGINAD "
					+ "FROM DELTA.GEN_USUARIO "
					+ "WHERE "+ clausulaWhere;
		
		Usuario usu1 = new Usuario();
		
		try {
			
			PreparedStatement stm = connection.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				usu1.setAtivo(Boolean.parseBoolean(rs.getString("IDTSTATUS")));
				usu1.setCodigo(rs.getString("CODUSUARIO"));
				usu1.setCodigoPerfil(rs.getString("CODPERFIL"));
				usu1.setNome(rs.getString("NOMCOMPLETO"));
				usu1.setLoginAD(rs.getString("NOMLOGINAD"));
			}
			
			stm.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usu1;
	}

	public List<Usuario> getListaUsuarioDispositivoMovel(String codempresa) {
		List<Usuario> usuarioLista = new ArrayList<>();
		
		String sql = "SELECT CASE WHEN IDTSTATUS = 'A' THEN 'true' ELSE 'false' END\n" +
					"       IDTSTATUS,\n" + 
					"       CODUSUARIO,\n" +  
					"       CODPERFIL,\n" + 
					"       NOMCOMPLETO,\n" +
					"       NOMLOGINAD\n" + 
					"  FROM DELTA.GEN_USUARIO,\n" + 
					"       DELTA.GEN_EMPRESA EMP\n" + 
					" WHERE CODEMPRESALOCADO = EMP.CODEMPRESA\n" + 
					"   AND CODEMPRESALOCADO = " + codempresa + "\n" + 
					"   AND IDTSTATUS = 'A'\n" + 
					"   AND CODPERFIL IN (120,\n" + 
					"                         60,\n" + 
					"                         33,\n" + 
					"                         50,\n" + 
					"                         296)\n" + 
					" ORDER BY NOMCOMPLETO DESC";

	
		
			Usuario usu1 = new Usuario();
		
			try {
				
				PreparedStatement stm = connection.prepareStatement(sql);
				
				ResultSet rs = stm.executeQuery();
				
				while(rs.next()){
					usu1.setAtivo(Boolean.parseBoolean(rs.getString("IDTSTATUS")));
					usu1.setCodigo(rs.getString("CODUSUARIO"));
					usu1.setCodigoPerfil(rs.getString("CODPERFIL"));
					usu1.setNome(rs.getString("NOMCOMPLETO"));
					usu1.setLoginAD(rs.getString("NOMLOGINAD"));
					
					usuarioLista.add(usu1);
					
				}
				//usuarioLista.stream()
				//  			.sorted((object1, object2) -> object1.getNome().compareTo(object2.getNome()));
				stm.close();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return usuarioLista;
	}
}
