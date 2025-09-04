package org.jrae.rentavehiculos.dominio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jrae.rentavehiculos.persistence.entity.Vehiculo;
import org.jrae.rentavehiculos.persistence.crud.VehiculoCrud;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    VehiculoCrud crud;

    @Override
    public List<Vehiculo> listarVehiculos() {
        return crud.findAll();
    }

    @Override
    public Vehiculo buscarPorId(Integer id) {
        return findById(id).orElse(null);
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        crud.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {
        crud.delete(vehiculo);
    }
}
