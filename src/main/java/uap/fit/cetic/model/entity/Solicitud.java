package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uap.fit.cetic.model.enums.EstadoSolicitud;
import uap.fit.cetic.model.enums.TipoSolicitud;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_persona")
  private Cliente cliente;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "solicitud_motivo",
    joinColumns = @JoinColumn(name = "nro_solicitud"),
    inverseJoinColumns = @JoinColumn(name = "id_motivo")
  )
  private Set<Motivo> listaSolicitudMotivo;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nro_solicitud")
  private Long nroSolicitud;

  @Column(name = "fecha_solicitud", nullable = false)
  private LocalDateTime fechaSolicitud;

  @Column(name = "observacion", length = 155)
  private String observacion;

  @Column(name = "descripcion", length = 155)
  private String descripcion;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_solicitud", length = 55)
  private TipoSolicitud tipoSolicitud;

  @Column(name = "estado_solicitud", nullable = false)
  @Enumerated(EnumType.STRING)
  private EstadoSolicitud estadoSolicitud;
}

