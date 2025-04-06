package com.example.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private double precio;

    @ManyToOne
    @JoinColumn(name = "competitor_id") // clave foránea
    private Competitor competitor;

    public Producto() {}

    public Producto(String nombre, double precio, Competitor competitor) {
    this.nombre = nombre;
    this.precio = precio;
    this.competitor = competitor;
}


    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }

    public void setPrecio(double precio) { this.precio = precio; }

    public Competitor getCompetitor() { return competitor; }

    public void setCompetitor(Competitor competitor) { this.competitor = competitor; }
}
