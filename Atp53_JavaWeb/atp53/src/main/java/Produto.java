import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class Produto extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String paramentValor = req.getParameter("valor");
        String paramentId = req.getParameter("id_categoria");

        PrintWriter out = resp.getWriter();
        if (paramentValor != null && paramentId != null) {
            float valor = Float.parseFloat(paramentValor); 
            int id_categoria = Integer.parseInt(paramentId);
            out.printf("Modulo Produto = Nome Prod = %s - %.2f - %d", nome, valor, id_categoria);
        }else{
            out.printf("Modulo Produto = Nome Prod = %s - %.2f", nome);
        }
    }
}
