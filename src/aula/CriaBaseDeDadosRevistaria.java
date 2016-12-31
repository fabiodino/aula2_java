package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaBaseDeDadosRevistaria {
	public static void main(String[] args) throws Exception {

		// Abre conexao
		System.out.println("Abrindo conexao...");
		Connection conexao = ConnectionFactory.createConnection();

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