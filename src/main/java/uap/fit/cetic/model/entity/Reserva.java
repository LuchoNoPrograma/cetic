package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_solicitud", nullable = false)
  private Solicitud solicitud;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_reserva", nullable = false)
  private Long idReserva;

  @Column(name = "fecha_reserva", nullable = false)
  private String motivo;
}
