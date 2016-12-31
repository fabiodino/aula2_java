package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class InsereEditora {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		System.out.println("Digite o nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		e.setEmail(entrada.nextLine());

		entrada.close();

		// String sql = "INSERT INTO Editora (nome, email) " + " VALUES ('" +
		// e.getNome() + "', '" + e.getEmail() + "')";
		String sql = "INSERT INTO Editora (nome, email) VALUES (?, ?)";

		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		comando.setString(1, e.getNome());
		comando.setString(2, e.getEmail());

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
