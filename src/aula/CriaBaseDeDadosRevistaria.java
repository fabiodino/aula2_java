package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CriaBaseDeDadosRevistaria {
	public static void main(String[] args) throws Exception {

		String stringDeConexao = "jdbc:mysql://localhost:3306/revistaria";
		String usuario = "fabio";
		String senha = "123456";

		// Cria e Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

		System.out.println("Apagando a base de dados revistaria...");
		String sql = "DROP DATABASE IF EXISTS revistaria";
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Criando a base de dados revistaria...");
		sql = "CREATE DATABASE revistaria";
		comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Fechando conexao...");
		conexao.close();
	}
}
