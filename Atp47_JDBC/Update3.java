package BancoDeDados.Atp47_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update3 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe3, altere o nome da primeira e segunda categoria da tabela e exiba a quantidade de linhas afetadas.
            Statement statement = conn.createStatement();
            String sql = "UPDATE categoria SET nome = 'refeição' WHERE id = 2 OR id = 1";
            statement.execute(sql);

            int linhasAfetadas = statement.getUpdateCount();
            System.out.printf("\nO nº de linhas afetadas é de: %d", linhasAfetadas);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
