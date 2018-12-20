<%-- 
    Document   : agregarPersona
    Created on : 19-dic-2018, 18:58:26
    Author     : usuario
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Persona</title>
    </head>
    <body>
        <h1>Agregar Persona</h1>
        <form action="ServletControlador" method="post">
            <input type="hidden" name="accion" value="agregar"/>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" style="display: block;" />
            <label for="apePaterno">Apellido Paterno:</label>
            <input type="text" id="apePaterno" name="apePaterno" style="display: block;"/>
            <label for="email">eMail:</label>
            <input type="text" id="email" name="email" style="display: block;"/>
            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono" style="display: block;"/>
            <input type="submit" value="Enviar" />
        </form>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
