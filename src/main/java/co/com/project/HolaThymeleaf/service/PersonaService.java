package co.com.project.HolaThymeleaf.service;

import java.util.List;

import co.com.project.HolaThymeleaf.domain.Persona;

public interface PersonaService {

    public List<Persona> listarPersonas();

    public void save(Persona persona);

    public void delete(Persona persona);

    public Persona findPerson(Persona persona);
    
}
