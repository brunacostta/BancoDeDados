package BancoDeDados.Atp51_DAO.View;

import java.sql.Connection;

import BancoDeDados.Atp51_DAO.dao.CategoriaDao;
import BancoDeDados.Atp51_DAO.dao.ConnectionFactory;
import BancoDeDados.Atp51_DAO.model.Categoria;

public class Read {
    public static void main(String[] args) {
        try (Connection conn = new ConnectionFactory().getConnection();){
            CategoriaDao dao = new CategoriaDao(conn);

            for (Categoria c : dao.read()) {
                System.out.println(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
