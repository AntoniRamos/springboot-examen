package com.ramos.examenfinal.implServices;

import com.ramos.examenfinal.entities.Estudiante;
import com.ramos.examenfinal.repositories.EstudiantesRepository;
import com.ramos.examenfinal.services.EstudiantesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudiantesImplService implements EstudiantesService {
    @Autowired
    EstudiantesRepository estudianteRepository;

    @Override
    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    @Override
    @Transactional
    public Estudiante create(Estudiante estudiante) {

        return  estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        return  estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante getById(Integer id) {
        return estudianteRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public List<Estudiante> getAllOrderedByAgeDesc() throws Exception {
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        return estudiantes.stream().sorted(Comparator.comparingInt(Estudiante::getEdad).reversed()).collect(Collectors.toList());
    }
}
