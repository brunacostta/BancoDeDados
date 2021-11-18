package BancoDeDados.Atp51_DAO.View;

import java.sql.Connection;
import BancoDeDados.Atp51_DAO.dao.CategoriaDao;
import BancoDeDados.Atp51_DAO.dao.ConnectionFactory;

public class Delete {
    public static void main(String[] args) {
        try(Connection conn = new ConnectionFactory().getConnection();) {
            CategoriaDao dao = new CategoriaDao(conn);
            dao.delete(6);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
