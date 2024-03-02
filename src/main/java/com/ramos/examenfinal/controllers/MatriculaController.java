package com.ramos.examenfinal.controllers;

import com.ramos.examenfinal.entities.Estudiante;
import com.ramos.examenfinal.entities.Matricula;
import com.ramos.examenfinal.services.EstudiantesService;
import com.ramos.examenfinal.services.MatriculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculasService matriculasService;
    @GetMapping
    public ResponseEntity<List<Matricula>> getAll() throws  Exception{
        List<Matricula> matriculas = matriculasService.getAll();
        return ResponseEntity.ok(matriculas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getById(@PathVariable("id") Integer id) throws  Exception{
        Matricula matricula = matriculasService.getById(id);
        return ResponseEntity.ok(matricula);
    }

    @PostMapping
    public ResponseEntity<Matricula> save(@RequestBody Matricula matricula)throws Exception{
        Matricula newMatricula = matriculasService.create(matricula);
        return new ResponseEntity<>(newMatricula, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> update(@RequestBody Matricula matricula) throws  Exception{
        Matricula updateMatricula = matriculasService.update(matricula);
        return ResponseEntity.ok(updateMatricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws  Exception{
        matriculasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
