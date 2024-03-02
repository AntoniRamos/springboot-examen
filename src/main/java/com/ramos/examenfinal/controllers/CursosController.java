package com.ramos.examenfinal.controllers;

import com.ramos.examenfinal.dtos.EstudiantesPorCursoDto;
import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.services.CursosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursosController {
    @Autowired
    private CursosService cursosService;
    @GetMapping
    public ResponseEntity<List<Curso>> getAll() throws  Exception{
        List<Curso> cursos = cursosService.getAll();
         return ResponseEntity.ok(cursos);
    }

    @GetMapping("/alumnos-por-curso/{id}")
    public ResponseEntity<?> getStudentsByCourse(@PathVariable("id") Integer id) throws  Exception{
        List<Curso> cursos = cursosService.getAll();
        EstudiantesPorCursoDto estudiantesPorCursoDto = cursosService.getStudentsOfCourse(id);

        return new ResponseEntity<>(estudiantesPorCursoDto, HttpStatus.OK);
    }

    @GetMapping("/estudiantes-por-curso")
    public ResponseEntity<?> getCoursesWithStudents() throws  Exception{
        List<EstudiantesPorCursoDto> estudiantesPorCursosList = new ArrayList<EstudiantesPorCursoDto>();
        estudiantesPorCursosList = cursosService.getAllStudentsByCourse();

        return new ResponseEntity<>(estudiantesPorCursosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") Integer id) throws  Exception{
        Curso curso = cursosService.getById(id);
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody  @Valid Curso curso)throws Exception{
        Curso newCourse = cursosService.create(curso);
        return new ResponseEntity<>(newCourse,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@Valid @RequestBody Curso curso) throws  Exception{
        Curso updateProduct = cursosService.update(curso);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws  Exception{
        cursosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
