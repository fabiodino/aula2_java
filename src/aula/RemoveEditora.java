package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveEditora {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

		// Instancia entrada
		Scanner entrada = new Scanner(System.in);

		// Cria user input
		System.out.println("Digite o id da editora que deseja remover: ");
		Long id = Long.parseLong(entrada.nextLine());

		// Fecha entrada
		entrada.close();

		// Cria string sql
		String sql = "DELETE FROM Editora WHERE id = ?";

		// Cria comando
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Recebe parametro
		comando.setLong(1, id);

		// Executa comando
		System.out.println("Executando comando...");
		comando.execute();

		// Fecha conexao
		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
