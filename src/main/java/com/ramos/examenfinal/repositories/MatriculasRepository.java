package com.ramos.examenfinal.repositories;

import com.ramos.examenfinal.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculasRepository  extends JpaRepository<Matricula,Integer> {
}
