/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DaoGenerico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entity2;

/**
 *
 * @author brandao
 */
@WebServlet(name = "Entity2Servlet", urlPatterns = {"/Entity2Servlet"})
public class Entity2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Long id = Long.valueOf(request.getParameter("id"));
        if (op.equals("remove")) {
            DaoGenerico<Entity2> daoEntity2 = new DaoGenerico<Entity2>(Entity2.class);
            daoEntity2.remove(id);

        }
        if (op.equals("alterar")) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op.equals("inserir")) {
            String nome = request.getParameter("nome");
            String campo = request.getParameter("campo");

            Entity2 entity2 = new Entity2();
            entity2.setNome(nome);
            entity2.setCampo(campo);

            DaoGenerico<Entity2> daoEntity2 = new DaoGenerico<Entity2>(Entity2.class);
            daoEntity2.insert(entity2);
            response.sendRedirect("Entity2.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
