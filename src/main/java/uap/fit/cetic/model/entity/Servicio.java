package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uap.fit.cetic.model.enums.EstadoServicio;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "motivo",
      joinColumns = @JoinColumn(name = "id_servicio"),
      inverseJoinColumns = @JoinColumn(name = "id_tipo_servicio")
    )
    private Set<TipoServicio> listaMotivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nro_solicitud", nullable = false)
    private Solicitud solicitud;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    @Column(name = "costo_total", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Float costoTotal;

    @Column(name = "estado_servicio", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoServicio estadoServicio;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "descripcion")
    private String descripcion;
}
