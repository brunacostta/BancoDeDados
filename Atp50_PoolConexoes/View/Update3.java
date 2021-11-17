package BancoDeDados.Atp50_PoolConexoes.View;

import java.sql.Connection;
import java.sql.PreparedStatement;

import BancoDeDados.Atp49_Factory_TryWithResource.ConnectionFactory;

public class Update3 {
    public static void main(String[] args) {
        //Crie uma classe ConnectionFactory para abrigar sua fábrica de conexões. Esta classe deve ter um método que retorne uma Conexão com o Postgres.
                    
        ////Altere as 4 classes para utilizarem a fábrica de conexões e tambem o try with resource para que a conexão seja fechada automaticamente.
        try (Connection conn = new ConnectionFactory().getConnection();){
            int id = 1;
            String descricao = "alimento";

            String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, descricao);
            prepStatement.setInt(2, id);
            prepStatement.execute();

            int linhasAfetadas = prepStatement.getUpdateCount();
            System.out.printf("\nO nº de linhas afetadas é de: %d", linhasAfetadas);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
