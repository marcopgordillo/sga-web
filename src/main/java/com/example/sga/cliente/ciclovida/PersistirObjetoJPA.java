/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.sga.domain.Persona;
/**
 *
 * @author usuario
 */
public class PersistirObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Inicia la transaccion
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Pedro", "Luna", null, "pluna@mail.com", "19292943");
        //Paso 2. Inicia transacción
        tx.begin();
        //Paso 3. Ejecuta SQL
        em.persist(persona1);
        //Paso 4. Commit/rollback
        tx.commit();
        //Objeto en estado detached
        log.debug("Objeto persistido:" + persona1);
        //Cerramos el Entity Manager
        em.close();  
    }
}
