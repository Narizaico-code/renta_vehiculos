package org.jrae.rentavehiculos.dominio.service;

import org.jrae.rentavehiculos.persistence.entity.Reserva;

import java.util.List;

public interface IReservaService {
    List<Reserva> listarReserva();
    Reserva buscarReservaPorId(Integer codigo);
    void guardarReserva(Reserva reserva);
    void eliminarReserva(Reserva reserva);
}
