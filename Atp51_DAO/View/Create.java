package BancoDeDados.Atp51_DAO.View;

import java.sql.Connection;
import java.sql.SQLException;

import BancoDeDados.Atp51_DAO.dao.CategoriaDao;
import BancoDeDados.Atp51_DAO.dao.ConnectionFactory;
import BancoDeDados.Atp51_DAO.model.Categoria;

public class Create {
    public static void main(String[] args) {
        
        try (Connection conn = new ConnectionFactory().getConnection()){
            CategoriaDao dao = new CategoriaDao(conn);
            Categoria cat = new Categoria("Add", "Add2");
            
            dao.create(cat);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

  