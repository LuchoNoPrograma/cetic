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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "servicio_motivo",
      joinColumns = @JoinColumn(name = "id_servicio"),
      inverseJoinColumns = @JoinColumn(name = "id_motivo")
    )
    private Set<Motivo> listaMotivo;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Asignacion> listaAsignacion;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<DetalleServicio> listaDetalleServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nro_solicitud")
    private Solicitud solicitud;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    @Column(name = "costo_total", columnDefinition = "DECIMAL(10,2)")
    private Float costoTotal;

    @Column(name = "estado_servicio")
    @Enumerated(EnumType.STRING)
    private EstadoServicio estadoServicio;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "observacion")
    private String observacion;
}
