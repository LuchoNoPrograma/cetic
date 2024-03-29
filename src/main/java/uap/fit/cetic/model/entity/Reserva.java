package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uap.fit.cetic.model.enums.EstadoReserva;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
  @OneToMany(mappedBy = "reserva")
  private List<DetalleReserva> listaDetalleReserva;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "nro_solicitud", nullable = false)
  private Solicitud solicitud;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_reserva", nullable = false)
  private Long idReserva;

  @Column(name = "motivo", nullable = false)
  private String motivo;

  @Column(name = "nombre_actividad", length = 55)
  private String nombreActividad;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_reserva", nullable = false)
  private EstadoReserva estadoReserva;
}
