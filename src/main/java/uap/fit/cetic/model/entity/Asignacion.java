package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asignacion")
public class Asignacion {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tecnico")
  private Tecnico tecnico;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_servicio")
  private Servicio servicio;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_asignacion", nullable = false)
  private Long idAsignacion;

  @Column(name = "fecha_asignacion", nullable = false)
  private LocalDateTime fechaAsignacion;
}
