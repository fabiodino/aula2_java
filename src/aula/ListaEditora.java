package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListaEditora {

	public static void main(String[] args) throws Exception {

		// Abre conexao
		Connection conexao = ConnectionFactory.createConnection();

		// Cria string sql
		String sql = "SELECT * FROM Editora";

		// Cria comando sql
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Executa comando sql
		System.out.println("Executando comando...");
		ResultSet resultado = comando.executeQuery();

		// Cria ArrayList (diferente do array pois o tamanho não é fixo)
		// List é interface e ArrayList é classe
		List<Editora> lista = new ArrayList<Editora>();

		// Armazena resultados
		while (resultado.next()) {
			Editora e = new Editora();
			e.setId(resultado.getLong("id"));
			e.setNome(resultado.getString("nome"));
			e.setEmail(resultado.getString("email"));
			lista.add(e);
		}

		// Exibe resultados
		System.out.println("Resultados encontrados: \n");
		for (Editora editora : lista) { // para cada elemento da lista...
			System.out.println("ID: " + editora.getId());
			System.out.println("Nome: " + editora.getNome());
			System.out.println("Email: " + editora.getEmail());
			System.out.println("------------------------------");
		}

		// Fecha conexao
		System.out.println("\nFechando conexao...");
		conexao.close();

	}

}
