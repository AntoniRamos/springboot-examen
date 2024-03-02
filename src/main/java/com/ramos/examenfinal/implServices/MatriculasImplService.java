package com.ramos.examenfinal.implServices;

import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.entities.DetalleMatricula;
import com.ramos.examenfinal.entities.Estudiante;
import com.ramos.examenfinal.entities.Matricula;
import com.ramos.examenfinal.repositories.CursosRepository;
import com.ramos.examenfinal.repositories.DetalleMatriculaRepository;
import com.ramos.examenfinal.repositories.EstudiantesRepository;
import com.ramos.examenfinal.repositories.MatriculasRepository;
import com.ramos.examenfinal.services.MatriculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculasImplService implements MatriculasService {
    @Autowired
    MatriculasRepository matriculasRepository;

    @Autowired
    EstudiantesRepository estudiantesRepository;

    @Autowired
    CursosRepository cursosRepository;


    @Override
    public List<Matricula> getAll() {
        return matriculasRepository.findAll();
    }

    @Override
    public Matricula create(Matricula matricula) throws Exception {
        Estudiante estudiante = estudiantesRepository.findById(matricula.getEstudiante().getId()).orElse(new Estudiante());
        matricula.setEstudiante(estudiante);
        for(DetalleMatricula detalleMatricula: matricula.getDetalleMatriculas()){
            DetalleMatricula detalle = new DetalleMatricula();
            detalleMatricula.setMatricula(matricula);
            Curso curso = cursosRepository.findById(detalleMatricula.getCurso().getId()).orElse(new Curso());
            detalleMatricula.setCurso(curso);
        }
        Matricula newMatricula = matriculasRepository.save(matricula);
        return matriculasRepository.save(newMatricula);
    }

    @Override
    public Matricula update(Matricula matricula) throws Exception {
        return matriculasRepository.save(matricula);
    }

    @Override
    public Matricula getById(Integer id) throws Exception {
        return matriculasRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) throws Exception {
        matriculasRepository.deleteById(id);
    }
}
