package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class InsereEditora {
	public static void main(String[] args) throws Exception {
		String stringDeConexao = "jdbc:mysql://localhost:3306/revistaria";
		String usuario = "fabio";
		String senha = "123456";

		System.out.println("Abrindo conexao...");
		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		System.out.println("Digite o nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		e.setEmail(entrada.nextLine());

		entrada.close();

		String sql = "INSERT INTO Editora (nome, email) " + " VALUES ('" + e.getNome() + "', '" + e.getEmail() + "')";

		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		System.out.println("Executando comando...");
		comando.execute();

		System.out.println("Recuperando o ID gerado pelo SGBD...");
		ResultSet generatedKeys = comando.getGeneratedKeys();
		generatedKeys.next();
		e.setId(generatedKeys.getLong(1));
		System.out.println("ID: " + e.getId());

		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
