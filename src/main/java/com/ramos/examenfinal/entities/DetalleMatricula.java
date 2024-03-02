package com.ramos.examenfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "detalle_matricula")
public class DetalleMatricula {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Curso curso;

    @NotEmpty
    @NonNull
    @Column(name = "aula",nullable = false)
    private String aula;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Matricula matricula;
}
