package BancoDeDados.Atp47_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read1 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe1, liste id e nome de todas as linhas da tabela Categoria.
            Statement statement = conn.createStatement();
            statement.execute("SELECT id, nome FROM produto");

            //Result = restorno da consulta
            ResultSet result = statement.getResultSet();

            //Imprimir resultado
            while (result.next()) {
                int id = result.getInt("Id");
                String nome = result.getString("Nome");
                
                System.out.printf("\nId: %d || Nome: %s ", id, nome);
                System.out.println("\n===================================");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
