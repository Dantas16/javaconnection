package br.com.gti5;

import java.util.ArrayList;
import java.util.Map;

import br.com.gti5.dao.ClienteDao;

/**
 * Main class of this example of database connection and common actions (Insert, update, list, delete)
 * @author Gutemberg Dantas <http://github.com/Dantas16>
 * OBS: Exemplo simples apenas para aprendizado, se acha gambiarra faz fork e complementa
 * PS: Simple example of connection and database manipulation only for learning
 * 
 *  ** INSIRA USUÁRIO E SENHA NA CLASSE Conexao NOS ATRIBUTOS user e pass
 */
public class Principal {

	public static void main(String[] args) {
		
		//Dao com ações de insert, update, select e delete
		ClienteDao cd = new ClienteDao();
		
		//Insert records in the database client
		if (cd.inserirClientes("Cliente 1", "Endereço do cliente 1")) {
			System.out.println("Cliente 1 inserido!\n");
	   	} else {
	   		System.out.println("Falha ao inserir Cliente 1\n");
	   	}
		//Cliente 2
	   	if (cd.inserirClientes("Cliente 2", "Endereço do cliente 2")) {
	   		System.out.println("Cliente 2 inserido!\n");
	   	} else {
	   	   System.out.println("Falha ao inserir cliente 2\n");
	   	}
	   	//Cliente 3
		if (cd.inserirClientes("Cliente 3", "Endereço do cliente 3")) {
			System.out.println("Cliente 3 inserido!\n");
		} else {
			System.out.println("Falha ao inserir cliente 3\n");
		}
		
		System.out.println("\n----- CLIENTES NO BANCO -------\n");
		//Armazena os maps (clientes)
		ArrayList<Map<String,String>> clientes = new ArrayList<Map<String,String>>();
		//Obtém Lista de clientes
		clientes = cd.getClientes();
		for (Map<String,String> cliente : clientes) {
			for(String clik : cliente.keySet()) {
				String cli = cliente.get(clik);
				System.out.println(cli);
			}
			System.out.println();
		}
		
	}
	
}
