/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.web;

import com.example.sga.domain.Persona;
import com.example.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mgordillo
 */
@WebServlet("/ListarPersonas")
public class ServletControlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    private PersonaService personaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Persona> personas = personaService.listarPersonas();
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("listarPersonas.jsp").forward(request, response);
    }
}
