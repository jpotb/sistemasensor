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

            <form action="USUARIOServlet" name="USUARIO" method="POST"> 
                Nome: <input type="text" name="nome"><br/>
                Senha: <input type="password" name="senha" ><br/>
                Grupo<select name="grupo">
                    
                </select><br/>
                Status: <input type="checkbox" name="status"><br/>
                <input type="hidden" value="inserir" name="op">
                <input type="submit" value="enviar" name="enviar">
            </form>

        </div>

    </body>
</html>
