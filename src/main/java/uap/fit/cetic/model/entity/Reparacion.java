package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reparacion")
public class Reparacion implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_solicitud", referencedColumnName = "id_solicitud")
    private Solicitud solicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_servicio", referencedColumnName = "id_servicio", nullable = false)
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "monto", precision = 2, nullable = false, length = 8)
    private Float monto;

    /*
    * Columan donde se registrara las casillas de verificacion en el formulario de solicitud
    * */
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String detalle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparacion")
    private Long idReparacion;
}

