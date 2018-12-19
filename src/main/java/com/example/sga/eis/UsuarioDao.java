/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.eis;

import com.example.sga.domain.Usuario;
import java.util.List;

/**
 *
 * @author mgordillo
 */
public interface UsuarioDao {
    public List<Usuario> findAllUsuarios();

    public Usuario findUsuarioById(Usuario usuario);

    public void insertUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);    
}
