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
public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
//Paso 1. Inicia transacción 1
        tx.begin();
//Paso 2. Ejecuta SQL de tipo select
//Puede ser un find o un merge si ya tenemos el objeto
        Persona persona1 = em.find(Persona.class, 3);
        log.debug("Objeto encontrado:" + persona1);
//Paso 3. setValue (nuevoValor)
        persona1.setApeMaterno("Aguirre");
        persona1.setApeMaterno("Torres");
//Paso 4. Termina transacción 1
//Ejecuta el update, aunque hayamos hecho 2 cambios sobre el objeto
//unicamente persiste el último cambio del objeto
//es decir, el valor de apeMaterno=Torres
        tx.commit();
//Objeto en estado detached
        log.debug("Objeto modificado:" + persona1);
    }
}
