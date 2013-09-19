<%-- 
    Document   : edEntity1
    Created on : Sep 18, 2013, 7:12:22 PM
    Author     : brandao
--%>

<%@page import="dao.DaoGenerico"%>
<%@page import="java.util.List"%>
<%@page import="model.Entity1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Entity1Servlet" method="POST">
            <%
                Entity1 entity1 = (Entity1) session.getAttribute("entity1");
            %>
            Nome: <input type="text" name="nome" value="<%out.println(entity1.getNome());%>">
            Campo:<select name="campo">
                <option value="-1">Selecione um campo</option>
                <%
                    DaoGenerico<Entity1> daoEntity1 = new DaoGenerico<Entity1>(Entity1.class);
                    List<Entity1> entity1s = daoEntity1.list();
                    for (Entity1 e : entity1s) {
                        if (e.getId() == entity1.getId()) {
                            out.println("<option value=\"" + e.getId() + "\" selected=\"selected\">" + e.getNome() + " </option>");
                        } else {
                            out.println("<option value=\"" + e.getId() + "\">" + e.getNome() + "</option>");
                        }
                    }
                %>
            </select> <br/>
            <input type="hidden" name="op" value="alterar"/>
            <input type="hidden" name="id" value="<%out.println(entity1.getId());%>"/>
            <input type="submit" value="Alterar">
        </form>

    </body>
</html>
