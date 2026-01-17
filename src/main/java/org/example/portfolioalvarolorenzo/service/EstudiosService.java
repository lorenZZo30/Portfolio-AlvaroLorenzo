package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Estudios;
import org.example.portfolioalvarolorenzo.repository.EstudiosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiosService {

    private final EstudiosRepository estudiosRepository;

    public EstudiosService(EstudiosRepository estudiosRepository) {
        this.estudiosRepository = estudiosRepository;
    }

    public List<Estudios> findAll() {
        return estudiosRepository.findAllByOrderByFechaInicioDesc();
    }

    public Estudios findById(Long id) {
        return estudiosRepository.findById(id).orElse(null);
    }

    public Estudios save(Estudios estudios) {
        return estudiosRepository.save(estudios);
    }

    public void delete(Long id) {
        estudiosRepository.deleteById(id);
    }
}
