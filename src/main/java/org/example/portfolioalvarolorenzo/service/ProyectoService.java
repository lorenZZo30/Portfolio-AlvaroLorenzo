package org.example.portfolioalvarolorenzo.service;

import org.example.portfolioalvarolorenzo.model.Lenguaje;
import org.example.portfolioalvarolorenzo.model.Proyecto;
import org.example.portfolioalvarolorenzo.repository.LenguajeRepository;
import org.example.portfolioalvarolorenzo.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<Proyecto> findAll() {
        return proyectoRepository.findAllByOrderByFechaDesc();
    }

    public Proyecto getById(Long id) {
        return proyectoRepository.findById(id).get();
    }

    @Transactional
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Transactional
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }

    // Método para asignar lenguajes a un proyecto
    @Transactional
    public Proyecto asignarLenguajes(Long proyectoId, List<Long> lenguajesIds) {
        Optional<Proyecto> proyectoOpt = proyectoRepository.findById(proyectoId);

        // El isPresent es parte del Optional para ver si existe.
        if (proyectoOpt.isPresent()) {
            Proyecto proyecto = proyectoOpt.get();

            // Limpiar lenguajes actuales
            proyecto.getLenguajes().clear();

            // Agregar nuevos lenguajes
            if (lenguajesIds != null && !lenguajesIds.isEmpty()) {
                Set<Lenguaje> lenguajes = new HashSet<>();
                for (Long lenguajeId : lenguajesIds) {
                    Optional<Lenguaje> lenguajeOpt = lenguajeRepository.findById(lenguajeId);
                    if (lenguajeOpt.isPresent()) {
                        lenguajes.add(lenguajeOpt.get());
                    }
                }
                proyecto.setLenguajes(lenguajes);
            }

            return proyectoRepository.save(proyecto);
        }

        return null;
    }
}