package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection createConnection() throws SQLException {
		// Cria conexao
		String stringDeConexao = "jdbc:mysql://localhost:3306/revistaria";
		String usuario = "root";
		String senha = "123456";

		return DriverManager.getConnection(stringDeConexao, usuario, senha);
	}
}
