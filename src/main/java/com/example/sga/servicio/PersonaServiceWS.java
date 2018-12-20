/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.servicio;

import com.example.sga.domain.Persona;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author usuario
 */
@WebService
public interface PersonaServiceWS {
    @WebMethod
    public List<Persona> listarPersonas();
}
