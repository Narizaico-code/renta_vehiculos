package org.jrae.rentavehiculos.dominio.service;

import org.jrae.rentavehiculos.persistence.crud.ReservaCrud;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservaService implements IReservaService {

    @Autowired
    private ReservaCrud crud;

    @Override
    public List<Reserva> listarReserva() {
        return crud.findAll();
    }

    @Override
    public Reserva buscarReservaPorId(Integer codigo) {
        Reserva reserva = crud.findById(codigo).orElse(null);
        return reserva;
    }

    public void guardarReserva(Reserva reserva) {
        crud.save(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        crud.delete(reserva);
    }
}
