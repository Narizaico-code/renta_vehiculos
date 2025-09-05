package org.jrae.rentavehiculos.persistence.entity;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaUsuarioId implements Serializable {
    @Column(name = "codigo_usuario")
    private Integer codigo_usuario;

    @Column(name = "codigo_reserva")
    private Integer codigo_reserva;
}
