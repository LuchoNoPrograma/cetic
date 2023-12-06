package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uap.fit.cetic.model.enums.EstadoServicio;
import uap.fit.cetic.model.enums.EstadoSolicitud;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_solicitud")
    private Long nroSolicitud;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "observacion", length = 256)
    private String observacion;

    @Column(name = "estado_solicitud", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estadoSolicitud;
}

