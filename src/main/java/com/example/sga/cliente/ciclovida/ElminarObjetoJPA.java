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
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author usuario
 */
public class ElminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
// Paso 1. Inicia transacción 1
        EntityTransaction tx1 = em.getTransaction();
        tx1.begin();
// Paso 2. Ejecuta SQL de tipo select
//Proporcionamos un id_persona valido
        Persona persona1 = em.find(Persona.class, 3);
// Paso 3. Termina transacción 1
        tx1.commit();
// Objeto en estado detached
        log.debug("Objeto encontrado:" + persona1);
// Paso 4. Incia transacción 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
// Paso 5. Ejecuta SQL (es un delete)
        em.remove(persona1);
// Paso 6. Termina transacción 2
// Al momento de hacer commit,
//se realiza el delete
        tx2.commit();
// Objeto en estado detached ya modificado
//Ya no es posible resincronizarlo en otra transacción
//Solo está en memoria, pero al terminar el método se eliminará
        log.debug("Objeto eliminado:" + persona1);
    }
}
