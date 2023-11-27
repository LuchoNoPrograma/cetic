package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horario")
public class Horario implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_laboratorio", referencedColumnName = "id_laboratorio", nullable = false)
    private Laboratorio laboratorio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", nullable = false)
    private Long idHorario;

    @Column(name = "id_laboratorio", nullable = false)
    private Integer idLaboratorio;

    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalDateTime horaFin;

    @Column(name = "descripcion", length = 155)
    private String descripcion;

    @Column(name = "estado", length = 55)
    private String estado;
}
