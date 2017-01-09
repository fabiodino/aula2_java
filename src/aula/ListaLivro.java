package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListaLivro {

	public static void main(String[] args) throws Exception {

		// Abre conexao
		Connection conexao = ConnectionFactory.createConnection();

		// Cria string sql
		String sql = "SELECT * FROM Livro";

		// Cria comando sql
		PreparedStatement comando = conexao.prepareStatement(sql);

		// Executa comando
		System.out.println("Executando comando...");
		ResultSet resultado = comando.executeQuery();

		// Cria ArrayList (diferente do array pois o tamanho não é fixo)
		// List é interface e ArrayList é classe
		List<Livro> lista = new ArrayList<Livro>();

		// Armazena resultados
		while (resultado.next()) {
			Livro l = new Livro();
			l.setId(resultado.getLong("id"));
			l.setTitulo(resultado.getString("titulo"));
			l.setPreco(resultado.getDouble("preco"));
			l.setEditoraId(resultado.getLong("editora_id"));
			lista.add(l);
		}

		// Exibe resultado
		System.out.println("Resultados encontrados: \n");
		for (Livro livro : lista) {
			System.out.println("ID: " + livro.getId());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Preco: " + livro.getPreco());
			System.out.println("Editora ID: " + livro.getEditoraId());
			System.out.println("-------------------------------");
		}

		// Fecha conexao
		System.out.println("\nFechando conexao...");
		conexao.close();
	}

}
