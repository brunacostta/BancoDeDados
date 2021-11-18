package BancoDeDados.Atp51_DAO.View;

import java.sql.Connection;

import BancoDeDados.Atp51_DAO.dao.CategoriaDao;
import BancoDeDados.Atp51_DAO.dao.ConnectionFactory;
import BancoDeDados.Atp51_DAO.model.Categoria;

public class Update {
    public static void main(String[] args) {
                
        try (Connection conn = new ConnectionFactory().getConnection();){
            CategoriaDao dao = new CategoriaDao(conn);
            Categoria model = new Categoria(3, "Teste");
            System.out.printf("\nO nº de linhas afetadas é de: %d", dao.update(model));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
