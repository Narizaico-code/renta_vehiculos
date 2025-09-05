package org.jrae.rentavehiculos.persistence.crud;

import org.jrae.rentavehiculos.persistence.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaCrud  extends JpaRepository<Reserva, Integer> {

}
