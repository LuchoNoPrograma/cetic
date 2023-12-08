package uap.fit.cetic.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import uap.fit.cetic.model.enums.EstadoServicio;
import uap.fit.cetic.model.enums.EstadoSolicitud;
import uap.fit.cetic.model.enums.TipoSolicitud;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "solicitud")
public class Solicitud implements Serializable {
  @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL)
  private Reserva reserva;

  @OneToMany(mappedBy = "solicitud",fetch = FetchType.LAZY)
  private List<Servicio> listaServicio;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_persona")
  private Cliente cliente;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nro_solicitud")
  private Long nroSolicitud;

  @Column(name = "fecha_solicitud")
  private LocalDateTime fechaSolicitud;

  @Column(name = "fecha_entrega")
  private LocalDateTime fechaEntrega;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tecnico")
  private Tecnico tecnico;

  @Column(name = "observacion", length = 155)
  private String observacion;

  @Column(name = "descripcion", length = 155)
  private String descripcion;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_solicitud", length = 55)
  private TipoSolicitud tipoSolicitud;

  @Column(name = "estado_solicitud")
  @Enumerated(EnumType.STRING)
  private EstadoSolicitud estadoSolicitud;

  @Transient
  @JsonProperty
  @Getter(AccessLevel.NONE)
  private boolean esValidoEntrega;

  public boolean esValidoEntrega(){
    if(this.tipoSolicitud == TipoSolicitud.SERVICIO_TECNICO && (this.listaServicio != null || this.listaServicio.isEmpty())){
      return this.listaServicio.stream().allMatch(s -> s.getEstadoServicio() == EstadoServicio.FINALIZADO);
    }
    else return false;
  }
}

