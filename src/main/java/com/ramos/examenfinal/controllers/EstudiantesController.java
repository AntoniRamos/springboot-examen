package com.ramos.examenfinal.controllers;

import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.entities.Estudiante;
import com.ramos.examenfinal.services.CursosService;
import com.ramos.examenfinal.services.EstudiantesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {
    @Autowired
    private EstudiantesService estudiantesService;
    @GetMapping
    public ResponseEntity<List<Estudiante>> getAll() throws  Exception{
        List<Estudiante> estudiantes = estudiantesService.getAll();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/ordenadosDescendentePorEdad")
    public ResponseEntity<List<Estudiante>> getAllOrderedByAgeDesc() throws  Exception{
        List<Estudiante> estudiantes = estudiantesService.getAllOrderedByAgeDesc();
        return ResponseEntity.ok(estudiantes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable("id") Integer id) throws  Exception{
        Estudiante estudiante = estudiantesService.getById(id);
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@Valid  @RequestBody Estudiante estudiante)throws Exception{

        Estudiante newEstudiante = estudiantesService.create(estudiante);
        return new ResponseEntity<>(newEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@Valid @RequestBody Estudiante estudiante) throws  Exception{
        Estudiante updateEstudiante = estudiantesService.update(estudiante);
        return ResponseEntity.ok(updateEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws  Exception{
        estudiantesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
