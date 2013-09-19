<%-- 
    Document   : USUARIO 
    Created on : Sep 18, 2013, 2:43:50 PM
    Author     : brandao
--%>

<%@page import="model.USUARIO"%>
<%@page import="javax.persistence.Entity"%>
<%@page import="java.util.List"%>
<%@page import="model.Entity2"%>
<%@page import="dao.DaoGenerico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USUARIO</title>
    </head>
    <body>
        <div>
            <fieldset style=" width: 200px; height: 200px;background: snow">
                <legend>LISTA DE USUARIO</legend>
                <%
                    DaoGenerico<USUARIO> dao = new DaoGenerico<USUARIO>(USUARIO.class);
                    dao.list();
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>Nome</th>");
                    out.println("<th></th>");
                    out.println("<th></th>");
                    out.println("</tr>");
                    for (USUARIO e : dao.list()) {

                        out.println("<tr>");
                        out.println("<td>" + e.getNome() + "</td>");
                        out.println("<td><a href=\"USUARIOServlet?id=" + e.getId() + "&op=remove\">Remover</a></td>");
                        out.println("<td><a href=\"USUARIOServlet?id=" + e.getId() + "&op=find\">Editar</a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                %>
            </fieldset>  
        </div>
    </body>
</html>