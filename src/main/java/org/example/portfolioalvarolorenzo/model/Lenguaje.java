package org.example.portfolioalvarolorenzo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "lenguajes")
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "icono_url")
    private String iconoUrl;

    // Relación Many-to-Many (lado NO propietario)
    @ManyToMany(mappedBy = "lenguajes")
    private Set<Proyecto> proyectos = new HashSet<>();

    // Constructores
    public Lenguaje() {}

    public Lenguaje(String nombre, String iconoUrl) {
        this.nombre = nombre;
        this.iconoUrl = iconoUrl;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIconoUrl() {
        return iconoUrl;
    }

    public void setIconoUrl(String iconoUrl) {
        this.iconoUrl = iconoUrl;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lenguaje lenguaje = (Lenguaje) o;
        return Objects.equals(id, lenguaje.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}