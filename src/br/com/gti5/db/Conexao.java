package br.com.gti5.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe simples para abertura de conexao com o banco
 * Simple classe to connect with mysql database
 * @author Gutemberg Dantas <http://github.com/Dantas16>
 */
public class Conexao {
	
	/** 
	 * Nome do banco de dados
	 * Database name 
	 */
	private String db = "testes";
	/** 
	 * Usuário do banco de dados NUNCA USAR ROOT, CRIE UM USUÁRIO ESPECIFICO
	 * Database username 
	 */
	private String user = "";
	/** 
	 * Senha
	 * Database Password  
	 */
	private String pass = "";
	/** 
	 * Conexão com o banco
	 * Database connection 
	 */
	private Connection conn= null;
	
	/**
	 * Abre conexao com o banco e retorna um objeto Connection
	 * Open a new connection with the database or return a existing object Connection
	 */
	public Connection getConexao() {	
		try {
			
			if (this.conn!=null) {
				return this.conn;
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.db,this.user,this.pass);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return this.conn;
	}
	
	/**
	 * Encerra a conexão ativa com o banco
	 * Close the active connection
	 */
	public boolean closeConn() {
		if(this.conn!=null) {
			return false;
		}
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
