package BancoDeDados.ViewExJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class View {
    public static void main(String[] args) {
        try {
            //criar uma string para salvar a url de acesso ao banco  e quebrar a url para facilitar a manutencao e visualizacao

            String driverType = "jdbc";
            String driverName = "postgresql";
            String host = "localhost";
            int port = 5432;
            String database = "postgres";
            String user = "postgres";
            String pwd = "123456";

            String connectionString = String.format("%s:%s://%s:%d/%s", driverType, driverName, host, port, database);
            
            Connection conn = DriverManager.getConnection(connectionString, user, pwd);
            
            conn.close();
        } catch (SQLException e) {
            System.out.println("nao foi possível conectar ao banco");
        }
    }
}