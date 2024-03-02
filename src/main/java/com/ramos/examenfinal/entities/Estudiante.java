package com.ramos.examenfinal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity(name = "estudiantes")
public class Estudiante {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NonNull
    @Column(name = "nombres")
    private String nombres;

    @NotEmpty
    @Column(name = "apellidos",nullable = false)
    private String apellidos;


    @Size(min = 8,max = 8)
    @Column(name = "dni",nullable = false,length = 8)
    private String dni;


    @Max(value = 100)
    @Min(value = 1)
    @Column(name = "edad",nullable = false)
    private int edad;

    //@OneToMany(cascade = CascadeType.MERGE,mappedBy = "estudiante")
    //Collection<Matricula> matriculas;
}
