package com.grupobolivar.banco.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

// Anotaciones de Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Anotaciones de JPA
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    // Anotacion de javax persistence para llave primaria
    @Id
    // Anotacion de javax persistence para indicar que la llave es autogenerada
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Anotacion de javax persistence para indicar la columna a la que apunta este atributo
    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "CONTRASENA")
    private String contrasena;

    @Column(name = "ULTIMO_INGRESO")
    private LocalDateTime ultimoIngreso;

}
