package BancoDeDados.Atp47_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Create2 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe2, insira uma nova Categoria e imprima o id gerado.
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO categoria(nome,descricao)VALUES('diversos','outros')";

            statement.execute(sql, statement.RETURN_GENERATED_KEYS);
            ResultSet ids = statement.getGeneratedKeys();

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
