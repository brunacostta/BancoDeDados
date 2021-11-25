package com.bruna.atp53.servlets;

import java.io.IOException;

import com.bruna.atp53.dao.CategoriaDao;
import com.bruna.atp53.models.Categoria;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria/alterar")
public class CategoriaAlterarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDao dao = new CategoriaDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Categoria model = dao.readById(id);

        RequestDispatcher rd = req.getRequestDispatcher("/categoria/alterar.jsp");
        req.setAttribute("model", model);
        rd.forward(req, resp);
    }
}
