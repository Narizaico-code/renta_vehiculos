package org.jrae.rentavehiculos.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioCurd  extends JpaRepository<Usuario, Integer> {
}
