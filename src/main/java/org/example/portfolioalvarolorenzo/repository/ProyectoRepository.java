package org.example.portfolioalvarolorenzo.repository;

import org.example.portfolioalvarolorenzo.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    // Ordenar proyectos por fecha descendente
    List<Proyecto> findAllByOrderByFechaDesc();
}