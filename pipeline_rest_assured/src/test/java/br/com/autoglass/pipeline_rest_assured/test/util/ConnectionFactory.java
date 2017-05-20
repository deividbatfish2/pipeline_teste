package br.com.autoglass.pipeline_rest_assured.test.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConnectionFactory {

	private String host = "havana.autoglass.com.br";
    private String user = "QUALIDADE.TI";
    private String pass = "teste";
   
    public Connection c;
   
    /**
     * Construtor da classe
     *
     * @param host Host em que se deseja conectar
     * @param user Nome do usu�rio
     * @param pass Senha do usu�rio
     */
   
    /**
     * M�todo que estabelece a conex�o com o banco de dados
     *
     * @return True se conseguir conectar, falso em caso contr�rio.
     */
    public Connection getConnection() {
        
        String serverName = this.host;
        String portNumber = "1521";
        String servico    = "HAVANA";
        String userName   = this.user;
        String passName   = this.pass;
        String url = "jdbc:oracle:thin:@"+serverName + ":" + portNumber + ":" + servico; 
             
        try {
            this.c = DriverManager.getConnection(url,userName, passName);
        } catch( SQLException e ) {
        	throw new RuntimeException(e);
        }
        
        return this.c;
    }

    /**
     * Esse m�todo executa a query dada, e retorna um ResultSet
     * Talvez fosse melhor id�ia fazer esse m�todo lan�ar uma exception
     * a faze-lo retornar null como eu fiz, por�m isso � apenas um exemplo
     * para demonstrar a funcionalidade do comando execute
     *
     * @param query String contendo a query que se deseja executar
     * @return ResultSet em caso de estar tudo Ok, null em caso de erro.
     */
    public ResultSet executar( String query ) {
        Statement st;
        ResultSet rs;
       
        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch ( Exception e ) {
        	e.printStackTrace();
        }
       
        return null;
    }
   
    /**
     * Executa uma query como update, delete ou insert.
     * Retorna o n�mero de registros afetados quando falamos de um update ou delete
     * ou retorna 1 quando o insert � bem sucedido. Em outros casos retorna -1
     *
     * @param query A query que se deseja executar
     * @return 0 para um insert bem sucedido. -1 para erro
     */
    public int inserir( String query ) {
        Statement st;
        int result = -1;
       
        try {
            st = this.c.createStatement();
            result = st.executeUpdate(query);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
       
        return result;
    }

    
    /**
     * M�todo que estabelece a desconex�o com o banco de dados
     */

	public void close() {
		try {
			c.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}
    
}
