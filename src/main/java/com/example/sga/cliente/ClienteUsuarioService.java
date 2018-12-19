/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.cliente;

import com.example.sga.domain.Usuario;
import com.example.sga.servicio.UsuarioServiceRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author mgordillo
 */
public class ClienteUsuarioService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            UsuarioServiceRemote usuarioService
                    = (UsuarioServiceRemote) jndi.lookup("java:global/sga-jee/UsuarioServiceImpl!com.example.sga.servicio.UsuarioServiceRemote");
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
            System.out.println("\nFin llamada al EJB desde el cliente");
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
