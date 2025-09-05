package org.jrae.rentavehiculos.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuarios")
//Lombok
@Data // Genera Setters y Getters
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode//Codigo de autentificacion de la entidad
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoUsuario;// perite null en vez de 0

    @Column
    private String correo;
    @Column
    private String contrasena;
    @Column
    private String telefono;
    @Column
    private String tipoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculo> vehiculos;
}
