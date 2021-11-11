package BancoDeDados.ViewExJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ViewRead{
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

            //Statement - query SQL
            Statement statement = conn.createStatement();
            statement.execute("SELECT * FROM pessoas");

            //Result = retorno da consulta
            ResultSet result = statement.getResultSet();

            //Imprimir resultado
            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                System.out.printf("%d - %s %s\n", id, nome, sobrenome);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possivel conectar");
        }
    }
}