package co.com.project.HolaThymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.project.HolaThymeleaf.dao.PersonaDao;
import co.com.project.HolaThymeleaf.domain.Persona;

@Service
public class PersonaServiceImple implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona);        
    }

    @Override
    @Transactional
    public void delete(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findPerson(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);  
    }

}
