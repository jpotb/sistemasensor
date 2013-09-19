/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.DaoGenerico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.USUARIO;

/**
 *
 * @author brandao
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class USUARIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Long id = Long.valueOf(request.getParameter("id"));
        if (op.equals("remove")) {
            DaoGenerico<USUARIO> daoUsuario = new DaoGenerico<USUARIO>(USUARIO.class);
            daoUsuario.remove(id);
            response.sendRedirect("Usuario.jsp");
        }
        if (op.equals("find")) {
            DaoGenerico<USUARIO> daoUsuario = new DaoGenerico<USUARIO>(USUARIO.class);
            USUARIO usuario = daoUsuario.obter(id);
            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                response.sendRedirect("edUsuario.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op.equals("inserir")) {
            String nome = request.getParameter("nome");
            String campo = request.getParameter("campo");

            USUARIO usuario = new USUARIO();
            usuario.setNome(nome);
            DaoGenerico<USUARIO> daoUsuario = new DaoGenerico<USUARIO>(USUARIO.class);
            daoUsuario.insert(usuario);
            response.sendRedirect("Usuario.jsp");
        }else if (op.equals("alterar")) {
            HttpSession session = request.getSession();
           
            USUARIO e = (USUARIO)session.getAttribute("usu");
            
            e.setNome(request.getParameter("nome"));
      
             
            DaoGenerico<USUARIO> dao = new DaoGenerico<USUARIO>(USUARIO.class);
            dao.update(e);
            response.sendRedirect("Usuario.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
