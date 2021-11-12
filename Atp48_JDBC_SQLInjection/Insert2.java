package BancoDeDados.Atp48_JDBC_SQLInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert2 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Altere a classe2 para receber os parâmetros nome e descrição através de variáveis e troque o Statement para PreparedStatement.
            String nome = "Diversão";
            String descricao = "Diversos";
            PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO categoria(nome,descricao)VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, nome);
            prepStatement.setString(2, descricao);

            prepStatement.execute();
            ResultSet ids = prepStatement.getGeneratedKeys();

            while (ids.next()) {
                int id = ids.getInt(1);
                System.out.printf("\nCategoria com id nº: %s inserido com sucesso! ",id);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
