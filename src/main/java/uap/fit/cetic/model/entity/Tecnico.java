package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private Long idTecnico;

    @Column(name = "ru", nullable = false, unique = true, length = 15)
    private String ru;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @Column(name = "hora_salida")
    private LocalTime horaSalida;
}
