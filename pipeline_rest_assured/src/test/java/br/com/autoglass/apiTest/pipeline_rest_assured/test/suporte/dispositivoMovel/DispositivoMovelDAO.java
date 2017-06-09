package br.com.autoglass.pipeline_rest_assured.test.suporte.dispositivoMovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.autoglass.pipeline_rest_assured.test.util.ConnectionFactory;

public class DispositivoMovelDAO {

	private Connection connection;
	
	public DispositivoMovelDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public DispositivoMovel getIMEIDispositivoMovel(String clausulaWhere){
		String sql = "SELECT CODIMEI, CODEMPRESA "
					+ "FROM DELTA.GEN_DISPOSITIVOMOVEL "
					+ "WHERE "+ clausulaWhere;
		
		DispositivoMovel dispositivo = new DispositivoMovel();
		
		try {
			
			PreparedStatement stm = connection.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				dispositivo.setIMEI(rs.getString("CODIMEI"));
				dispositivo.setCODEMPRESA(rs.getString("CODEMPRESA"));
			}
			
			stm.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dispositivo;
	}
}
