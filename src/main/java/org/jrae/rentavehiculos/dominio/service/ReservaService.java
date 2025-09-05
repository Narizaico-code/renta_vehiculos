package org.jrae.rentavehiculos.dominio.service;

import org.jrae.rentavehiculos.persistence.crud.ReservaCrud;
import org.jrae.rentavehiculos.persistence.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    ReservaCrud crud;

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
