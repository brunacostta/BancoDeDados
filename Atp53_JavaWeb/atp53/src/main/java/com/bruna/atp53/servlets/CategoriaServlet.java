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

@WebServlet(urlPatterns = "/categoria")
public class CategoriaServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDao dao = new CategoriaDao();
        Categoria model = new Categoria();
        
        model.setNome(req.getParameter("nome"));
        model.setDescricao(req.getParameter("descricao"));
        int id = dao.insert(model);

        model.setId(id);
        
        req.setAttribute("id", model.getId());
        RequestDispatcher rd = req.getRequestDispatcher("/categoria-sucesso.jsp");
        rd.forward(req, resp);
    }
}
