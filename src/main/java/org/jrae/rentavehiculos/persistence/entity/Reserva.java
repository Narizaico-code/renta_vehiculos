package org.jrae.rentavehiculos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Reservas")
//Lombok
@Data // Genera Setters y Getters
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode//Codigo de autentificacion de la entidad
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoReserva;// perite null en vez de 0

    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaFin;
    @Column
    private double costoTotal;
}
