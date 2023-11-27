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
    @JoinColumn(name = "fk_id_servicio", referencedColumnName = "id_servicio", nullable = false)
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column(name = "monto", precision = 2, nullable = false, length = 8)
    private Float monto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparacion")
    private Long idReparacion;
}

