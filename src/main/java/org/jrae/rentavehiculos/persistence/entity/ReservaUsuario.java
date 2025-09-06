package org.jrae.rentavehiculos.persistence.entity;


import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "ReservasUsuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservaUsuario implements Serializable {
    @EmbeddedId
    private ReservaUsuarioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codigo_reserva")
    @JoinColumn(name = "codigo_reserva", referencedColumnName = "codigoReserva")
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codigo_usuario")
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigoUsuario")
    private Usuario usuario;
}
