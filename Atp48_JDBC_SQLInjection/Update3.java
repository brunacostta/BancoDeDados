package BancoDeDados.Atp48_JDBC_SQLInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update3 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Altere a classe3 para  receber os nomes das categorias que serão alteradas, através de variáveis e troque o Statement para PreparedStatement.
            int id = 1;
            String descricao = "alimento";

            String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, descricao);
            prepStatement.setInt(2, id);
            prepStatement.execute();

            int linhasAfetadas = prepStatement.getUpdateCount();
            System.out.printf("\nO nº de linhas afetadas é de: %d", linhasAfetadas);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
