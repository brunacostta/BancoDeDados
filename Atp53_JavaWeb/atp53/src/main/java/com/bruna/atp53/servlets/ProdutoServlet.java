package com.bruna.atp53.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.bruna.atp53.models.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produto prod = new Produto();
        PrintWriter out = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String paramentValor = req.getParameter("valor");
        String paramentId = req.getParameter("id_categoria");

        prod.setNome(nome);

        if (paramentValor != null && paramentId != null) {
            prod.setValor(Float.parseFloat(paramentValor));
            prod.setIdCategoria(Integer.parseInt(paramentId)); 
            out.printf("Modulo Produtos || Produto = %s || %.2f || %d", prod.getNome(), prod.getValor(), prod.getIdCategoria());
        }else{
            out.printf("Modulo Produtos || Produto = %s", prod.getNome());
        }
    }
}
