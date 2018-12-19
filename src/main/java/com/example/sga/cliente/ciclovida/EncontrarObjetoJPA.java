/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.cliente.ciclovida;

import com.example.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author usuario
 */
public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
//Paso 1. Inicia transacción
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
//Paso 3. Termina transacción
        tx.commit();
//Objeto en estado detached
        log.debug("Objeto recuperado:" + persona1);
    }
}
