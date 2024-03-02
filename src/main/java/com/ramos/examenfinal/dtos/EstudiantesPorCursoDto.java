package com.ramos.examenfinal.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstudiantesPorCursoDto {
    private String curso;
    private List<String> estudiante;
}
