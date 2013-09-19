<%-- 
    Document   : Entity2
    Created on : Sep 18, 2013, 3:19:20 PM
    Author     : brandao
--%>

<%@page import="dao.DaoGenerico"%>
<%@page import="model.Entity2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entity Two</title>
    </head>
    <body>
        <div>
            <form action="Entity2Servlet" name="Entity1" method="POST">
                Nome: <input type="text" name="nome"><br/>
                Campo: <input type="text" name="campo"><br/>
                <input type="hidden" value="inserir" name="op">
                <input type="submit" name="enviar" value="enviar">
            </form>
        </div>
        <div>
             <%
            DaoGenerico<Entity2> dao = new DaoGenerico<Entity2>(Entity2.class);
            dao.list();
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Nome</th>");
            out.println("<th>Campo</th>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("</tr>");
            for (Entity2 e : dao.list()) {

                out.println("<tr>");
                out.println("<td>" + e.getNome() + "</td>");
                out.println("<td>" + e.getNome()+ "</td>");
                out.println("<td><a href=\"Entity2Servlet?id=" + e.getId() + "&op=remove\">Remover</a></td>");
                out.println("<td><a href=\"Entity2Servlet?id=" + e.getId() + "&op=find\">Editar</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            %>


        </div>
    </body>
</html>
