package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsereLivro {

	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Instancia input e objeto da tabela
		Scanner entrada = new Scanner(System.in);
		Livro l = new Livro();

		// Cria input do usuario
		System.out.println("Digite o titulo do livro: ");
		l.setTitulo(entrada.nextLine());

		System.out.println("Digite o preco do livro: ");
		l.setPreco(entrada.nextDouble());

		System.out.println("Digite o id da editora: ");
		l.setEditoraId(entrada.nextLong());

		// Fecha entrada
		entrada.close();

		// Cria string sql (sanitize)
		String sql = "INSERT INTO Livro (titulo, preco, editora_id) VALUES (?, ?, ?)";

		// Cria comando (return key)
		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Recebe parametro
		comando.setString(1, l.getTitulo());
		comando.setDouble(2, l.getPreco());
		comando.setLong(3, l.getEditoraId());

		// Executa comando
		System.out.println("Executando comando...");
		comando.execute();

		// Cria recupera id
		System.out.println("Recuperando o id gerado pelo SGBD...");
		// ResultSet devolve objeto (ele armazena os resultados da consulta)
		ResultSet generatedKeys = comando.getGeneratedKeys();

		// Retorna o id
		generatedKeys.next(); // next() percorre o registro (devolve booleano)

		// Insere o id no BD
		l.setId(generatedKeys.getLong(1));

		System.out.println("ID: " + l.getId());

		// Fecha conexao
		conexao.close();

	}

}
