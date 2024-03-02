package com.ramos.examenfinal.services;

import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.entities.Estudiante;

import java.util.List;

public interface EstudiantesService {
    List<Estudiante> getAll() throws  Exception;
    Estudiante create(Estudiante estudiante) throws  Exception;
    Estudiante update( Estudiante estudiante) throws  Exception;

    Estudiante getById(Integer id) throws  Exception;
    void delete(Integer id) throws  Exception;

    List<Estudiante> getAllOrderedByAgeDesc() throws  Exception;
}
