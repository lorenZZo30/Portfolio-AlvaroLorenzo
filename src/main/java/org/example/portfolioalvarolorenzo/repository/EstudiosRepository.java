package org.example.portfolioalvarolorenzo.repository;

import org.example.portfolioalvarolorenzo.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudiosRepository extends JpaRepository<Estudios, Long> {

    List<Estudios> findAllByOrderByFechaInicioDesc();
}
