package com.ramos.examenfinal.services;

import com.ramos.examenfinal.entities.Matricula;


import java.util.List;

public interface MatriculasService {
    List<Matricula> getAll() throws  Exception;

    Matricula create(Matricula matricula) throws  Exception;

    Matricula update(Matricula matricula) throws  Exception;

    Matricula getById(Integer id) throws  Exception;

    void delete(Integer id) throws  Exception;
}
