package org.example.portfolioalvarolorenzo.repository;

import org.example.portfolioalvarolorenzo.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    // Devuelve todos los datos en experiencia ordenador de más reciente a más antigua
    List<Experiencia> findAllByOrderByFechaInicioDesc();
}