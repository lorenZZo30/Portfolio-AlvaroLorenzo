package org.example.portfolioalvarolorenzo.repository;

import org.example.portfolioalvarolorenzo.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
    // Es la capa de acceso a los datos.
    // Se comunica directamente con la base de datos y
    // Spring genera la implementación automáticamente
    // Es decir, Info es la entidad que se gestiona
    // y el Long es la key

    // Por el JPARepository se implementan sin escribir nada
    // varios métodos como findAll, findById, save...
}