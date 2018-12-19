/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.eis;

import com.example.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;


    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        
    }    
}
