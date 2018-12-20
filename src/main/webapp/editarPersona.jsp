<%-- 
    Document   : editarPersona
    Created on : 19-dic-2018, 18:58:52
    Author     : usuario
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Persona</title>
    </head>
    <body>
        <h1>Modificar Persona</h1>
        <form action="ServletControlador" method="post">
            <input type="hidden" name="accion" value="modificar"/>
            <input type="hidden" name="idPersona" value="${persona.idPersona}"/>
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" value="${persona.nombre}" style="display: block;" />
            <label for="apePaterno">Apellido Paterno:</label>
            <input type="text" name="apePaterno" value="${persona.apePaterno}" style="display: block;"/>
            <label for="email">eMail:</label>
            <input type="text" name="email" value="${persona.email}" style="display: block;"/>
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" value="${persona.telefono}" style="display: block;"/>
            <input type="submit" name="guardar" value="guardar">
            <input type="submit" name="eliminar" value="eliminar">
        </form>
    </body>
</html>
