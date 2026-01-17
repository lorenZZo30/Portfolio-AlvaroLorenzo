package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Experiencia;
import org.example.portfolioalvarolorenzo.repository.ExperienciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;

    public ExperienciaService(ExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }

    // Devuelve toda la experiencia ordenada por fecha de inicio
    public List<Experiencia> getExperiencia() {
        return experienciaRepository.findAllByOrderByFechaInicioDesc();
    }

    // Devuelve una experiencia por id
    public Experiencia findById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    // Guardar experiencia actualizada
    public Experiencia save(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    // Eliminar una experiencia
    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }

}