package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tecnico")
public class Tecnico implements Serializable {
    @OneToOne(mappedBy = "tecnico")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private Long idTecnico;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 75)
    private String apellidos;

    @Column(name = "ci", nullable = false, length = 30)
    private String ci;

    @Column(name = "celular", nullable = false, length = 10)
    private String celular;

    @Column(name = "email", length = 55)
    private String email;

    @Column(name = "ru", nullable = false, unique = true, length = 15)
    private String ru;

    @Column(name = "descripcion", length = 55)
    private String descripcion;
}
