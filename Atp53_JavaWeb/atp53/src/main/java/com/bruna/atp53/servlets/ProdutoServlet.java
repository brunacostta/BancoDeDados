package com.bruna.atp53.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import com.bruna.atp53.dao.CategoriaDao;
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
    
        CategoriaDao dao = new CategoriaDao();
        Produto model = new Produto();
        PrintWriter out = resp.getWriter();
        
        String nome = req.getParameter("nome");
        String paramentValor = req.getParameter("valor");
        String paramentId = req.getParameter("id_categoria");

        model.setNome(nome);

        if (paramentValor != null && paramentId != null) {
            model.setValor(Float.parseFloat(paramentValor));
            model.setIdCategoria(Integer.parseInt(paramentId)); 
            out.printf("Modulo Produtos || Produto = %s || %.2f || %d", model.getNome(), model.getValor(), model.getIdCategoria());
        }else{
            out.printf("Modulo Produtos || Produto = %s", model.getNome());
        }
    }
}
