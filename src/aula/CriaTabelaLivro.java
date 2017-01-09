package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaTabelaLivro {

	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Cria string sql
		System.out.println("Criando tabela Livro...");
		String sql = "CREATE TABLE Livro (" + "id BIGINT NOT NULL AUTO_INCREMENT," + "titulo VARCHAR (225) NOT NULL,"
				+ "preco DOUBLE NOT NULL," + "editora_id BIGINT NOT NULL," + "PRIMARY KEY (id),"
				+ "FOREIGN KEY fk_editora (editora_id) REFERENCES Editora (id)" + ")" + "ENGINE = InnoDB";

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
