package org.jrae.rentavehiculos.persistence.crud;

import org.jrae.rentavehiculos.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioCrud extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByCorreo(String correo);
}
