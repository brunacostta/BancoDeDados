package BancoDeDados.Atp47_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete4 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe4, delete as ultimas categorias cadastradas.
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM categoria WHERE id > 7";
            statement.execute(sql);

            int linhasDeletadas = statement.getUpdateCount();
            System.out.printf("\nForam deletadas %d linhas.", linhasDeletadas);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
