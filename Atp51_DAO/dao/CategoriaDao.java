package BancoDeDados.Atp51_DAO.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BancoDeDados.Atp51_DAO.model.Categoria;

public class CategoriaDao {
    private Connection conn;
    public CategoriaDao(Connection conn){
        this.conn = conn;
    }

    public void create(Categoria model) throws SQLException {
            
        PreparedStatement prepStatement = this.conn.prepareStatement("INSERT INTO categoria(nome,descricao)VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        prepStatement.setString(1, model.getNome());
        prepStatement.setString(2, model.getDescricao());

        prepStatement.execute();
        ResultSet ids = prepStatement.getGeneratedKeys();

        while (ids.next()) {
            int id = ids.getInt(1);
            System.out.printf("\nCategoria com id nº: %s inserido com sucesso! ",id);
        }
    } 
    
    public ArrayList<Categoria> read() throws SQLException {
        ArrayList<Categoria> list = new ArrayList<Categoria>();

        PreparedStatement prepStatement = conn.prepareStatement("SELECT id, nome FROM categoria");
        prepStatement.execute();

        ResultSet result = prepStatement.getResultSet();

        while (result.next()) {
            Categoria model = new Categoria(result.getInt("id"), result.getString("Nome"));
            list.add(model);
        }
        return list;
    }

    public int update(Categoria model) throws SQLException {
            
        String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
        PreparedStatement prepStatement = conn.prepareStatement(sql);
        prepStatement.setString(1, model.getNome());
        prepStatement.setInt(2, model.getId());
        prepStatement.execute();

        return prepStatement.getUpdateCount();
    }

    public int delete(int id) {   
        int linhasDeletadas = 0;
        PreparedStatement prepStatement;
        try {
            prepStatement = conn.prepareStatement("DELETE FROM categoria WHERE id > ?");
            prepStatement.setInt(1, id);
            prepStatement.execute();
            linhasDeletadas = prepStatement.getUpdateCount();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhasDeletadas;
    }
}
