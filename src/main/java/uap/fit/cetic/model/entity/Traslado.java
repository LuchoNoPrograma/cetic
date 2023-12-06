package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "traslado")
@IdClass(TrasladoId.class)
public class Traslado {
  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_equipo")
  private Laboratorio idLaboratorio;

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_equipo")
  private Equipo idEquipo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tecnico")
  private Tecnico tecnico;

  @Column(name = "fecha_traslado", nullable = false)
  private LocalDateTime fechaTraslado;

  @Column(name = "observacion", length = 256)
  private String observacion;
}
