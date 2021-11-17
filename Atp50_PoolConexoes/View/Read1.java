package BancoDeDados.Atp50_PoolConexoes.View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BancoDeDados.Atp49_Factory_TryWithResource.ConnectionFactory;

public class Read1 {
    public static void main(String[] args) {
        //Crie uma classe ConnectionFactory para abrigar sua fábrica de conexões. Esta classe deve ter um método que retorne uma Conexão com o Postgres.
        
        //Altere as 4 classes para utilizarem a fábrica de conexões e tambem o try with resource para que a conexão seja fechada automaticamente.
        try (Connection conn = new ConnectionFactory().getConnection();){
            PreparedStatement prepStatement = conn.prepareStatement("SELECT id, nome FROM produto");
            prepStatement.execute();

            //Result = restorno da consulta
            ResultSet result = prepStatement.getResultSet();

            //Imprimir resultado
            while (result.next()) {
                int id = result.getInt("Id");
                String nome = result.getString("Nome");
                
                System.out.printf("\nId: %d || Nome: %s ", id, nome);
                System.out.println("\n===================================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
