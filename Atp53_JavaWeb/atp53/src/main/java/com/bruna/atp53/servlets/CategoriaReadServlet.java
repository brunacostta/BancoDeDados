package com.bruna.atp53.servlets;

import java.io.IOException;
import java.util.ArrayList;
import com.bruna.atp53.dao.CategoriaDao;
import com.bruna.atp53.models.Categoria;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = "/categoria/listar")
public class CategoriaReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDao dao = new CategoriaDao();
        ArrayList<Categoria> categorias;
        String nome = req.getParameter("nome");

        if(nome != null && nome != ""){
            categorias = dao.read(nome);
        }
        else{
            categorias = dao.read(nome);
        }          

        req.setAttribute("categorias", categorias);   
        RequestDispatcher rd = req.getRequestDispatcher("/categoria-lista.jsp");
        rd.forward(req, resp);
    } 
}
