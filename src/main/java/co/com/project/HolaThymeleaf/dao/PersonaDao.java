package co.com.project.HolaThymeleaf.dao;


import org.springframework.data.repository.CrudRepository;

import co.com.project.HolaThymeleaf.domain.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long>{
    

}
