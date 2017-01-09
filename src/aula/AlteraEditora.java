package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraEditora {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Instancia objeto tabela
		Editora e = new Editora();

		// Cria user input
		System.out.println("Digite o id da editora que deseja alterar: ");
		e.setId(Long.parseLong(entrada.nextLine()));

		System.out.println("Digite o novo nome da editora: ");
		e.setNome(entrada.nextLine());

		System.out.println("Digite o novo email da editora: ");
		e.setEmail(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Cria string sql
		String sql = "UPDATE Editora SET nome = ?, email = ? WHERE id =?";

		// Cria comando
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Recebe parametro
		comando.setString(1, e.getNome());
		comando.setString(2, e.getEmail());
		comando.setLong(3, e.getId());

		// Executa comando
		System.out.println("Executando comando...");
		comando.execute();

		// Fecha conexao
		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
