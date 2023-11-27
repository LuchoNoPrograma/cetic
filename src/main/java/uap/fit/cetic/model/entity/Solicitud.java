package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(name = "fecha_solicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;

    @Column(name = "observacion", length = 256)
    private String observacion;
}

