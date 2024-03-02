package com.ramos.examenfinal.repositories;

import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiante,Integer> {
}
