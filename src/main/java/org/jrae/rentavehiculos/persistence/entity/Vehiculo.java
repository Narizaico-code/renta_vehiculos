package org.jrae.rentavehiculos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Vehiculos")
//Lombok
@Data // Genera Setters y Getters
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode//Codigo de autentificacion de la entidad
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoVehiculo;// perite null en vez de 0

    @Column
    private String modelo;
    @Column
    private int año;
    @Column
    private double precioDiario;
    @Column
    private String disponible; //enum

    @ManyToOne
    @JoinColumn(name = "codigoUsuario", nullable = true)
    private Usuario usuario;
}
