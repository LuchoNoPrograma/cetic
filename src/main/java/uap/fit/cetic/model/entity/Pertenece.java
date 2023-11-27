package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pertenece")
public class Pertenece implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pertenece")
    private Long idPertenece;

    @Column(name = "fecha_entrega", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_entrega;

    @Column(name = "observacion", length = 256)
    private String observacion;
}

