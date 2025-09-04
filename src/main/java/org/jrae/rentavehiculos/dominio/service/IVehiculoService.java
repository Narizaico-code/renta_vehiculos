package org.jrae.rentavehiculos.dominio.service;
import org.jrae.rentavehiculos.persistence.entity.Vehiculo;
import java.util.List;
public interface IVehiculoService {
    List<Vehiculo> listarVehiculos();
    Vehiculo buscarPorId(Integer id);
    void guardarVehiculo(Vehiculo vehiculo);
    void eliminarVehiculo(Vehiculo vehiculo);
}
