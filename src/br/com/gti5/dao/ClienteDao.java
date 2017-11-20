package br.com.gti5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.gti5.db.Conexao;

/**
 * Classe com métodos que representão ações de insert, update, select
 * Class with insert, select, update and delete actions
 */
public class ClienteDao {

	/**
	 * Retorna uma coleção com clientes
	 * Return a Map collection with clients 
	 */
	public ArrayList<Map<String,String>> getClientes(){
		ArrayList<Map<String,String>> clientels = new ArrayList<Map<String,String>>();
		try {
			//Create a Conexao object
			Conexao db = new Conexao();
			//Get a new or existing connection
			Connection conn = db.getConexao();
			//Prepare the sql to query
			PreparedStatement ps = conn.prepareStatement("SELECT ID_CLI,NM,ENDERECO FROM cliente");
			//Excute and get the result of the query
			ResultSet rs = ps.executeQuery();
			//Perform the result
			while(rs.next()) {
				Map<String,String> cliente = new HashMap<String,String>();
								   cliente.put("id", rs.getString("NM"));
								   cliente.put("END", rs.getString("ENDERECO"));
				clientels.add(cliente);
			}
			rs.close();
			ps.close();
			db.closeConn(); //Finish the connection 
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return clientels;
	}
	
	/**
	 * Insere um cliente no banco
	 */
	public boolean inserirClientes(String nome, String endereco){
		boolean res = false;
		try {
			Conexao db = new Conexao();
			Connection conn = db.getConexao();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente (NM,ENDERECO) VALUES (?,?)");
							  ps.clearParameters();
							  ps.setString(1, nome);
							  ps.setString(2, endereco);
							  
			int inserido = ps.executeUpdate();
			
			if (inserido > 0) {
				res = true;
			}
			ps.close();
			db.closeConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	/**
	 * Atualiza um registro no banco
	 */
	public boolean updateCliente(int idcli, String nome, String endereco){
		boolean res = false;
		try {
			Conexao db = new Conexao();
			Connection conn = db.getConexao();
			PreparedStatement ps = conn.prepareStatement("UPDATE cliente SET NM = ?, ENDERECO = ? WHERE ID_CLI = ? LIMIT 1");
							  ps.clearParameters();
							  ps.setString(1, nome);
							  ps.setString(2, endereco);
							  ps.setInt(3, idcli);
			
			int atualizado = ps.executeUpdate();
			
			if (atualizado > 0) {
				res = true;
			}
			ps.close();
			db.closeConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
	/**
	 * Apaga um registro no banco
	 */
	public boolean deleteCliente(int idcli){
		boolean res = false;
		try {
			Conexao db = new Conexao();
			Connection conn = db.getConexao();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM cliente WHERE ID_CLI = ? LIMIT 1");
							  ps.clearParameters();
							  ps.setInt(1, idcli);
			
			int deleted = ps.executeUpdate();
			
			if (deleted > 0) {
				res = true;
			}
			ps.close();
			db.closeConn();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
}
