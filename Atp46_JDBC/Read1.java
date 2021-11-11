package BancoDeDados.Atp46_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read1 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe1, liste todos os dados de todas as colunas da tabela produto.
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM produto");

            //Result = restorno da consulta
            ResultSet result = statement.getResultSet();

            //Imprimir resultado
            while (result.next()) {
                int id = result.getInt("Id");
                String nome = result.getString("Nome");
                String descricao = result.getString("Descricao");
                float preco = result.getFloat("Preco");
                int categoria_id = result.getInt("Categoria_id");

                System.out.printf("\nId: %d || Nome: %s || Descrição: %s || Preço: R$%.2f || Categoria ID: %d", id, nome, descricao, preco, categoria_id);
                System.out.println("\n=========================================================================================");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
