/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.cliente.transacciones;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.sga.domain.Persona;
import com.example.sga.servicio.PersonaServiceRemote;
/**
 *
 * @author mgordillo
 */
public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!com.example.sga.servicio.PersonaServiceRemote");
log.debug("Iniciando prueba Manejo Transaccional PersonaService");
//Buscamos un objeto persona
        Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));
//Cambiamos la persona
        // persona1.setApeMaterno("Cambio con error....................................................................");
        persona1.setApeMaterno("Cambio sin errror");
        personaService.modificarPersona(persona1);
        log.debug("Objeto modificado:" + persona1);
        log.debug("Fin prueba EJB PersonaService");
    } 
}
