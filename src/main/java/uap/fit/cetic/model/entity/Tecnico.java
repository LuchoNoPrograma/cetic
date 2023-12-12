package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

@Builder
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

    @Column(name = "nombre", length = 30)
    private String nombre;

    @Column(name = "apellidos", length = 75)
    private String apellidos;

    @Column(name = "ci", length = 30)
    private String ci;

    @Column(name = "celular", length = 10)
    private String celular;

    @Column(name = "email", length = 55)
    private String email;

    @Column(name = "ru", unique = true, length = 15)
    private String ru;
    
    @Column(name = "horario", length = 100)
    private String horario;

    @Column(name = "descripcion", length = 55)
    private String descripcion;
}
