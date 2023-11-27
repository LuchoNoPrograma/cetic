package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona", nullable = false)
  private Persona persona;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_laboratorio", referencedColumnName = "id_laboratorio", nullable = false)
  private Laboratorio laboratorio;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asistencia")
  private Long idAsistencia;

  @Column(name = "hora_entrada", nullable = false)
  private LocalDateTime horaEntrada;

  @Column(name = "hora_salida")
  private LocalDateTime horaSalida;
}
