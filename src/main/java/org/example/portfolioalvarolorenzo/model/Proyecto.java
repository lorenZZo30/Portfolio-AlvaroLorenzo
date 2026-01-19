package org.example.portfolioalvarolorenzo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "imagen_url")
    private String imagenUrl;

    private LocalDate fecha;

    // Relación Many-to-Many (lado PROPIETARIO)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "proyecto_lenguaje",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "proyecto_id"),  // FK hacia Proyecto
            inverseJoinColumns = @JoinColumn(name = "lenguaje_id")  // FK hacia Lenguaje
    )
    private Set<Lenguaje> lenguajes = new HashSet<>();

    // Constructores
    public Proyecto() {}

    public Proyecto(String nombre, String descripcion, String githubUrl, String imagenUrl, LocalDate fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.githubUrl = githubUrl;
        this.imagenUrl = imagenUrl;
        this.fecha = fecha;
    }

    // Métodos auxiliares para gestionar la relación bidireccional
    public void agregarLenguaje(Lenguaje lenguaje) {
        this.lenguajes.add(lenguaje);
        lenguaje.getProyectos().add(this);
    }

    public void eliminarLenguaje(Lenguaje lenguaje) {
        this.lenguajes.remove(lenguaje);
        lenguaje.getProyectos().remove(this);
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(Set<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return Objects.equals(id, proyecto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}