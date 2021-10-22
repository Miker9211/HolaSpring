package co.com.project.HolaThymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.project.HolaThymeleaf.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}