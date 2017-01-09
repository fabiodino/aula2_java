package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraLivro {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Instancia objeto tabela
		Livro l = new Livro();

		// Cria user input
		System.out.println("Digite o id do livro que deseja alterar: ");
		l.setId(Long.parseLong(entrada.nextLine()));

		System.out.println("Digite o novo titulo do livro: ");
		l.setTitulo(entrada.nextLine());

		System.out.println("Digite o novo preco do livro: ");
		l.setPreco(Double.parseDouble(entrada.nextLine()));

		System.out.println("Digite o id da nova editora do livro: ");
		l.setEditoraId(Long.parseLong(entrada.nextLine()));

		// Fecha entrada
		entrada.close();

		// Cria string sql (sanitize)
		String sql = "UPDATE Livro SET titulo = ?, preco = ?, editora_id = ? WHERE id = ?";

		// Cria comando
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Recebe parametro
		comando.setString(1, l.getTitulo());
		comando.setDouble(2, l.getPreco());
		comando.setLong(3, l.getEditoraId());
		comando.setLong(4, l.getId());

		// Executa comando
		System.out.println("Executando comando...");
		comando.execute();

		// Fecha conexao
		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
