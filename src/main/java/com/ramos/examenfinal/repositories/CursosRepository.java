package com.ramos.examenfinal.repositories;

import com.ramos.examenfinal.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Curso,Integer> {
}
