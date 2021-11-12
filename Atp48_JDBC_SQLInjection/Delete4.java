package BancoDeDados.Atp48_JDBC_SQLInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete4 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Altere a classe4 para receber o Id da categorias a ser deletada através de variável e troque o Statement para PreparedStatement.
            int id = 6;
            PreparedStatement prepStatement = conn.prepareStatement("DELETE FROM categoria WHERE id > ?");
            prepStatement.setInt(1, id);
            prepStatement.execute();

            int linhasDeletadas = prepStatement.getUpdateCount();
            System.out.printf("\nForam deletadas %d linhas.", linhasDeletadas);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
