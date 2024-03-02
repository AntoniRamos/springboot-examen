package com.ramos.examenfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity(name = "matriculas")
public class Matricula {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estudiante estudiante;

    @Column(name = "estado",nullable = false)
    private boolean estado;


    @Column(name="date_of_Birth",nullable = false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "matricula",cascade = CascadeType.MERGE)
    Collection<DetalleMatricula> detalleMatriculas;

}
