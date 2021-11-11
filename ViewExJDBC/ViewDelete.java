package BancoDeDados.ViewExJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewDelete {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM pessoas WHERE id > 2";
            statement.execute(sql);   
            int linhasAfetadas = statement.getUpdateCount();
            System.out.println(linhasAfetadas);         
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
