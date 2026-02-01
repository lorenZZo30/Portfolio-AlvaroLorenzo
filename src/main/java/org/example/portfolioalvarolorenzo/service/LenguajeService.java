package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Lenguaje;
import org.example.portfolioalvarolorenzo.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<Lenguaje> findAll() {
        return lenguajeRepository.findAllByOrderByNameAsc();
    }

    public Lenguaje getById(Long id) {
        return lenguajeRepository.getById(id);
    }

    public Lenguaje save(Lenguaje lenguaje) {
        return lenguajeRepository.save(lenguaje);
    }

    public void delete(Long id) {
        lenguajeRepository.deleteById(id);
    }

    public Lenguaje findByName(String nombre) {
        return lenguajeRepository.getByName(nombre);
    }
}