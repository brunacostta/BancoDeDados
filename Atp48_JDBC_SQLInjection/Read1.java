package BancoDeDados.Atp48_JDBC_SQLInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read1 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Altere a classe1 para utilizar preparedStatement.
            PreparedStatement prepStatement = conn.prepareStatement("SELECT id, nome FROM produto");
            prepStatement.execute();

            //Result = restorno da consulta
            ResultSet result = prepStatement.getResultSet();

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
