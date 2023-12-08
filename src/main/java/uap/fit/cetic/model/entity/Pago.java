package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pago")
public class Pago implements Serializable {
  @ManyToOne
  @JoinColumn(name = "nro_solicitud", nullable = false)
  private Solicitud solicitud;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pago")
  private Long idPago;

  @Column(name = "fecha_pago", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaPago;

  @Column(name = "monto", nullable = false)
  private Float monto;
}
