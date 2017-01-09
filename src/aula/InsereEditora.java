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

		// Instancia entrada e objeto da tabela
		Scanner entrada = new Scanner(System.in);
		Editora e = new Editora();

		// Cria input do usuario
		System.out.println("Digite o nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.println("Digite o email da editora: ");
		e.setEmail(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Cria string sql (sanitize)
		// String sql = "INSERT INTO Editora (nome, email) " + " VALUES ('" +
		// e.getNome() + "', '" + e.getEmail() + "')";
		String sql = "INSERT INTO Editora (nome, email) VALUES (?, ?)";

		// Cria comando (return key)
		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Recebe parametro
		comando.setString(1, e.getNome());
		comando.setString(2, e.getEmail());

		// Executa comando
		System.out.println("Executando comando...");
		comando.execute();

		// Cria recupera id
		System.out.println("Recuperando o ID gerado pelo SGBD...");
		ResultSet generatedKeys = comando.getGeneratedKeys();

		// Retorna o id
		generatedKeys.next();

		// Insere o id no BD
		e.setId(generatedKeys.getLong(1)); // (1) indice da coluna

		System.out.println("ID: " + e.getId());

		// Fecha a conexao
		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
