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

@WebServlet(urlPatterns = "/categoria/listar")
public class CategoriaReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = new ConnectionFactory().getConnection();){
            PrintWriter out = resp.getWriter();
            CategoriaDao dao = new CategoriaDao(conn);
            for (Categoria model : dao.read()) {
                out.printf("\n%d - %s", model.getId(), model.getNome());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
