package org.example.portfolioalvarolorenzo.repository;

import org.example.portfolioalvarolorenzo.model.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {

    // Buscar lenguaje por nombre (útil para evitar duplicados)
    Lenguaje getByName(String nombre);

    // Ordenar por nombre alfabéticamente
    List<Lenguaje> findAllByOrderByNameAsc();


}