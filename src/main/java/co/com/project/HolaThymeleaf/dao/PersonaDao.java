package co.com.project.HolaThymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.project.HolaThymeleaf.domain.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    
}
