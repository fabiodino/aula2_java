package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaTabelaEditora {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Cria string sql
		System.out.println("Criando a tabela Editora...");
		String sql = "CREATE TABLE Editora (" + "id BIGINT NOT NULL AUTO_INCREMENT," + "nome VARCHAR (255) NOT NULL,"
				+ "email VARCHAR (255) NOT NULL," + "PRIMARY KEY (id)" + ")" + "ENGINE = InnoDB";

		// Cria comando
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Executa comando
		comando.execute();

		// Fecha comando
		comando.close();

		// Fecha conexao
		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
