package com.example.sga.beans;

import com.example.sga.domain.Persona;
import com.example.sga.servicio.PersonaService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author mgordillo
 */
@RequestScoped
@Named
public class PersonaBean {
    @Inject
    private PersonaService personaService;
    
    private Persona personaSeleccionada;
    
    List<Persona> personas;

    public PersonaBean() {
    }

    @PostConstruct
    public void inicializar() {
        personas = personaService.listarPersonas();
        personaSeleccionada = new Persona();
    }

    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.modificarPersona(persona);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }

    public void agregarPersona() {
        personaService.registrarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void eliminarPersona() {
        personaService.eliminarPersona(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
}
