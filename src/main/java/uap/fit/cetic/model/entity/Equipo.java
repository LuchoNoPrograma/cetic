
package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import uap.fit.cetic.model.enums.EstadoEquipo;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_laboratorio", referencedColumnName = "id_laboratorio")
    private Laboratorio laboratorio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo", nullable = false)
    private Long idEquipo;

    @Column(name = "cod_uap", length = 55)
    private String codUap;

    @Column(name = "cod_serie", nullable = false, unique = true, length = 55)
    private String codSerie;

    @Column(name = "color", length = 55)
    private String color;

    @Column(name = "modelo", length = 55)
    private String modelo;

    @Column(name = "marca", length = 55)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_equipo", length = 25)
    private EstadoEquipo estadoEquipo;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
