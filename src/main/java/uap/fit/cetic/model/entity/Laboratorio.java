package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uap.fit.cetic.model.enums.EstadoLaboratorio;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio", nullable = false)
    private Long idLaboratorio;

    @Column(name = "nombre", length = 55)
    private String nombre;

    @Column(name = "horario", length = 100)
    private String horario;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoLaboratorio estado;
}

