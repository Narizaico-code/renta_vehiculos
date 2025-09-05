package org.jrae.rentavehiculos.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.jrae.rentavehiculos.dominio.service.IReservaService;
import org.jrae.rentavehiculos.persistence.entity.Reserva;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservaController {

    @Autowired
    IReservaService reservaService;
    private List<Reserva> reservas;
    private Reserva reservaSeleccionada;

    private static final Logger logger = LoggerFactory.getLogger(ReservaController.class);
    String sl = System.lineSeparator();

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.reservas = this.reservaService.listarReserva();
        this.reservas.forEach(curso -> logger.info(curso.toString() + sl));
    }

    public void agregarReserva(){
        this.reservaSeleccionada = new Reserva();
    }

    public void guardarReserva(){
        logger.info("Reserva guardar" + this.reservaSeleccionada);
        if (this.reservaSeleccionada.getCodigoReserva() == null ){
            this.reservaService.guardarReserva(this.reservaSeleccionada);
            this.reservas.add(this.reservaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Reserva agregada"));
        }

        else {
            this.reservaService.guardarReserva(this.reservaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Reserva Actualizada") );
        }

        PrimeFaces.current().executeScript( "PF('venataModeloReserva').hide()");

        PrimeFaces.current().ajax().update("formulario-cursos:mensaje-emergente",
                "formulario-cursos:tabla-cursos");

    }

    public void eliminarReserva(){
        logger.info("Reserva a eliminar" + this.reservaService);
        this.reservaService.eliminarReserva(reservaSeleccionada);
        this.reservas.remove(reservaSeleccionada);
        this.reservaSeleccionada = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reserva eliminada"));
        PrimeFaces.current().ajax().update("formulario-cursos:mensaje-emergente",
                "formulario-cursos:tabla-cursos");
    }
/*
    public String ejecutar() {
        return "reserva.xhtml?faces-redirect=true";
    }*/
}
