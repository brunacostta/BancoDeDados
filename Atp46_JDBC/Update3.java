package BancoDeDados.Atp46_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update3 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe3, altere todos os produtos para a mesma categoria e exiba a quantidade de linhas afetadas.
            Statement statement = conn.createStatement();
            String sql = "UPDATE produto SET categoria_id = 1 where id > 0";
            statement.execute(sql);

            int linhasAfetadas = statement.getUpdateCount();
            System.out.printf("\nO nº de linhas afetadas é de: %d", linhasAfetadas);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
