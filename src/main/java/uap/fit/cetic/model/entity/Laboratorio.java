package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laboratoio")
public class Laboratorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio", nullable = false)
    private Long idLaboratorio;

    @Column(name = "nombre", length = 55)
    private String nombre;
}

