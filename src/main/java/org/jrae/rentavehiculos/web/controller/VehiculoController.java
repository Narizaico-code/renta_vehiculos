package org.jrae.rentavehiculos.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.jrae.rentavehiculos.dominio.service.IVehiculoService;
import org.jrae.rentavehiculos.persistence.entity.Vehiculo;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;
    private List<Vehiculo> vehiculos;
    private Vehiculo vehiculoSeleccionado;

    private static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.vehiculos = this.vehiculoService.listarVehiculos();
        this.vehiculos.forEach(vehiculos -> logger.info(vehiculos.toString()));
    }

    public void agregarVehiculo(){
        this.vehiculoSeleccionado = new Vehiculo();

    }

    public void guardarVehiculo(){
        logger.info("Vehiculo a guardar: "+this.vehiculoSeleccionado);
        //Agregar(Insertar)
        if (this.vehiculoSeleccionado.getCodigoVehiculo() == null){
            this.vehiculoService.guardarVehiculo(this.vehiculoSeleccionado);
            this.vehiculos.add(this.vehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Vehiculo agregar"));

        }
        //Mpdificar(Update)
        else{
            this.vehiculoService.guardarVehiculo(this.vehiculoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Vehiculo Actualizado"));
        }

        //Ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalVehiculo').hide()");

        //Actualiar la tabla con AJAX
        PrimeFaces.current().ajax().update("formulario-vehiculos:mensaje_emergente",
                "formulario-vehiculos:tabla-vehiculos");

        //Reset del vehiculoSeleccionado
        this.vehiculoSeleccionado = null;
    }

    public void eliminarVehiculo(){
        //Mostrar en consola
        logger.info("Vehiculo a eliminar: "+vehiculoSeleccionado);
        //llamar a nuestro servicio de eliminacion de Vehiculo
        this.vehiculoService.eliminarVehiculo(vehiculoSeleccionado);
        //Eliminarlo de la lista vehiculos
        this.vehiculos.remove(vehiculoSeleccionado);
        //limpiar clienteSeleccionado
        this.vehiculoSeleccionado = null;
        //enviar mnsaje emergente
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("vehiculo eliminado") );
        //Metodo ajax para actualizar la tabla
        PrimeFaces.current().ajax().update("formulario-vehiculos:mensaje_emergente",
                "formulario-vehiculos:tabla-vehiculos");
    }

}
