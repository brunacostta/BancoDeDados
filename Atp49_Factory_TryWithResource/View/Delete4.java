package BancoDeDados.Atp49_Factory_TryWithResource.View;

import java.sql.Connection;
import java.sql.PreparedStatement;

import BancoDeDados.Atp49_Factory_TryWithResource.ConnectionFactory;

public class Delete4 {
    public static void main(String[] args) {
        //Crie uma classe ConnectionFactory para abrigar sua fábrica de conexões. Esta classe deve ter um método que retorne uma Conexão com o Postgres.

        //Altere as 4 classes para utilizarem a fábrica de conexões e tambem o try with resource para que a conexão seja fechada automaticamente.
        try(Connection conn = new ConnectionFactory().getConnection();) {
        
            int id = 6;
    
            PreparedStatement prepStatement = conn.prepareStatement("DELETE FROM categoria WHERE id > ?");
            prepStatement.setInt(1, id);
            prepStatement.execute();

            int linhasDeletadas = prepStatement.getUpdateCount();
            System.out.printf("\nForam deletadas %d linhas.", linhasDeletadas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
