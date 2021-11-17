package BancoDeDados.Atp50_PoolConexoes.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import BancoDeDados.Atp49_Factory_TryWithResource.ConnectionFactory;

public class Insert2 {
    public static void main(String[] args) {
        //Crie uma classe ConnectionFactory para abrigar sua fábrica de conexões. Esta classe deve ter um método que retorne uma Conexão com o Postgres.
        
        //Altere as 4 classes para utilizarem a fábrica de conexões e tambem o try with resource para que a conexão seja fechada automaticamente.
        try (Connection conn = new ConnectionFactory().getConnection();){
            String nome = "Diversão";
            String descricao = "Diversos";
            PreparedStatement prepStatement = conn.prepareStatement("INSERT INTO categoria(nome,descricao)VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, nome);
            prepStatement.setString(2, descricao);

            prepStatement.execute();
            ResultSet ids = prepStatement.getGeneratedKeys();

            while (ids.next()) {
                int id = ids.getInt(1);
                System.out.printf("\nCategoria com id nº: %s inserido com sucesso! ",id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
