package com.ramos.examenfinal.repositories;

import com.ramos.examenfinal.entities.DetalleMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMatriculaRepository extends JpaRepository<DetalleMatricula,Integer> {
}
