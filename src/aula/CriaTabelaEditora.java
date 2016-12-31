package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaTabelaEditora {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		System.out.println("Criando a tabela Editora...");
		String sql = "CREATE TABLE Editora (" + "id BIGINT NOT NULL AUTO_INCREMENT," + "nome VARCHAR (255) NOT NULL,"
				+ "email VARCHAR (255) NOT NULL," + "PRIMARY KEY (id)" + ")" + "ENGINE = InnoDB";
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
