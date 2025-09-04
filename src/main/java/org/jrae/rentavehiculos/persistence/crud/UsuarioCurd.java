package org.jrae.rentavehiculos.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioCurd  extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByCorreo(String correo);
}
