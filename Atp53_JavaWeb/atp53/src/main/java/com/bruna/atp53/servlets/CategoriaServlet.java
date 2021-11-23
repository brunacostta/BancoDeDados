package com.bruna.atp53.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.bruna.atp53.dao.CategoriaDao;
import com.bruna.atp53.dao.ConnectionFactory;
import com.bruna.atp53.models.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class CategoriaServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            CategoriaDao dao = new CategoriaDao(conn);
            Categoria model = new Categoria();
        
            model.setNome(req.getParameter("nome"));
            model.setDescricao(req.getParameter("descricao"));
            int id = dao.insert(model);

            model.setId(id);
        
            PrintWriter out = resp.getWriter();
            out.printf("Categoria com id nº: %s inserido com sucesso! ",model.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
