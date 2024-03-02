package com.ramos.examenfinal.implServices;

import com.ramos.examenfinal.dtos.EstudiantesPorCursoDto;
import com.ramos.examenfinal.entities.Curso;
import com.ramos.examenfinal.entities.DetalleMatricula;
import com.ramos.examenfinal.entities.Matricula;
import com.ramos.examenfinal.exceptions.ModelNotFoundException;
import com.ramos.examenfinal.repositories.CursosRepository;

import com.ramos.examenfinal.repositories.DetalleMatriculaRepository;
import com.ramos.examenfinal.services.CursosService;
import com.ramos.examenfinal.services.MatriculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursosImplService implements CursosService {

    @Autowired
    CursosRepository cursosRepository;

    @Autowired
    MatriculasService matriculasService;
    @Autowired
    private DetalleMatriculaRepository detalleMatriculaRepository;

    @Override
    public List<Curso> getAll() {
        return cursosRepository.findAll();
    }

    @Override
    public Curso create(Curso curso) {
        return  cursosRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {

        return cursosRepository.save(curso);
    }

    @Override
    public Curso getById(Integer id) throws Exception {
        return cursosRepository.findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    public void delete(Integer id) {
        cursosRepository.findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND " + id));
        cursosRepository.deleteById(id);
    }

    @Override
    public EstudiantesPorCursoDto getStudentsOfCourse(Integer id_course) throws Exception {

        EstudiantesPorCursoDto estudiantesPorCursoDto = new EstudiantesPorCursoDto();
        List<Matricula> matriculas = matriculasService.getAll();

        List<String> students = new ArrayList<>();
        Curso curso = getById(id_course);
        for(Matricula matricula: matriculas){
            matricula.getDetalleMatriculas().forEach(data ->{
                if(data.getCurso().getId().equals(id_course) ){

                    students.add(matricula.getEstudiante().getNombres());
                    return;
                }
            });
        }
        estudiantesPorCursoDto.setEstudiante(students);
        estudiantesPorCursoDto.setCurso(curso.getNombre());
        return estudiantesPorCursoDto;
    }

    @Override
    public List<EstudiantesPorCursoDto> getAllStudentsByCourse() throws Exception {
        List<EstudiantesPorCursoDto> estudiantesPorCursoDtoList = new ArrayList<>();
        List<Matricula> matriculas = matriculasService.getAll();
        List<Curso> cursos  = cursosRepository.findAll();
        List<DetalleMatricula> detalleMatriculas = detalleMatriculaRepository.findAll();
        for(Curso curso: cursos){
            List<String> estudiantes = new ArrayList<>();

            for(DetalleMatricula detalleMatricula: detalleMatriculas){
                if(detalleMatricula.getCurso().getId().equals(curso.getId())){
                    EstudiantesPorCursoDto estudiantesPorCursoDto = new EstudiantesPorCursoDto();
                    estudiantesPorCursoDto.setCurso(curso.getNombre());
                    estudiantes.add(detalleMatricula.getMatricula().getEstudiante().getNombres());
                    estudiantesPorCursoDto.setEstudiante(estudiantes);
                    estudiantesPorCursoDtoList.add(estudiantesPorCursoDto);
                }
            }


        }

        return estudiantesPorCursoDtoList;
    }
}
