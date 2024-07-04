package uap.fit.cetic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uap.fit.cetic.model.enums.EstadoReserva;

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

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_reserva")
  private Reserva reserva;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_reserva", columnDefinition = "varchar(30) default 'PENDIENTE'")
  private EstadoReserva estadoReserva;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_detalle_reserva", nullable = false)
  private Long idDetalleReserva;

  @Column(name = "fecha_hora_inicio", nullable = false)
  private LocalDateTime fechaHoraInicio;

  @Column(name = "fecha_hora_fin", nullable = false)
  private LocalDateTime fechaHoraFin;

  @Column(name = "observacion", length = 155)
  private String observacion;
}
