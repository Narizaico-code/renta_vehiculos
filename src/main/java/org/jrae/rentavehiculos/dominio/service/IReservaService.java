package org.jrae.rentavehiculos.dominio.service;

import java.util.List;

public interface IReservaService {
    List<Reserva> listarReserva();
    Rserva buscarReservaPorId(Integer codigo);
    void guardarReserva(Rserva reserva);
    void eliminarReserva(Reserva reserva);
}
