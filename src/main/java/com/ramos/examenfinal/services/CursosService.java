package com.ramos.examenfinal.services;

import com.ramos.examenfinal.dtos.EstudiantesPorCursoDto;
import com.ramos.examenfinal.entities.Curso;

import java.util.List;

public interface CursosService {
    List<Curso> getAll() throws  Exception;
    Curso create(Curso curso) throws  Exception ;
    Curso update( Curso curso) throws  Exception;
    Curso getById(Integer id) throws  Exception;
    void delete(Integer id) throws  Exception;

    EstudiantesPorCursoDto getStudentsOfCourse(Integer id_course) throws  Exception;

    List<EstudiantesPorCursoDto> getAllStudentsByCourse() throws  Exception;
}
