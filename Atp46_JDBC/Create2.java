package BancoDeDados.Atp46_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Create2 {
    public static void main(String[] args) {
        try {
            //Crie uma conexão com o banco de dados postgresql utilizando JDBC(java.sql.*).
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
            
            //Na classe2, insira um novo produto na tabela e imprima o id gerado.
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO produto(nome,descricao,preco,categoria_id)VALUES('abobrinha','legume','2.99',2)";

            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet ids = statement.getGeneratedKeys();

            while (ids.next()) {
                int id = ids.getInt(1);
                System.out.printf("\nProduto com id nº: %s inserido com sucesso! ",id);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
