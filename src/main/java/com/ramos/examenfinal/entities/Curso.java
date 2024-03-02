package com.ramos.examenfinal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "cursos")
public class Curso {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nombre no puede ser vacio")
    @Column(name = "nombre",nullable = false,unique = true)
    private String nombre;

    @NotEmpty
    @Column(name = "siglas",nullable = false)
    private String siglas;


    @Column(name = "estado",nullable = false)
    private Boolean estado;
}
