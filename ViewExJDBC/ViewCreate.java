package BancoDeDados.ViewExJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewCreate {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

            Statement statement = conn.createStatement();
            String sql = "INSERT INTO pessoas(nome, sobrenome, idade, cpf)values('Teste', 'Java', 2, '789456123')";

            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet ids = statement.getGeneratedKeys();

            while(ids.next()){
                // comeca em 1(nao em 0)
                int id = ids.getInt(1);
                System.out.println(id);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
