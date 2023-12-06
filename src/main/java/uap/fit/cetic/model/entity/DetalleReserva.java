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
@Table(name = "detalle_reserva")
public class DetalleReserva {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_laboratorio")
  private Laboratorio laboratorio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_reserva")
  private Reserva reserva;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_detalle_reserva", nullable = false)
  private Long idDetalleReserva;

  @Column(name = "hora_inicio", nullable = false)
  private LocalDateTime horaInicio;

  @Column(name = "hora_fin", nullable = false)
  private LocalDateTime horaFin;

  @Column(name = "observacion", length = 155)
  private String observacion;
}
