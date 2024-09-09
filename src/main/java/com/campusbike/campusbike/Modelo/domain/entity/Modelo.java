package com.campusbike.campusbike.Modelo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="modelo_id")
    private Long id;

    @Column(name="nombre", columnDefinition="VARCHAR(100)")
    private String nombre;

    @Column(name="descripcion", columnDefinition="VARCHAR(200)")
    private String descripcion;

    public Modelo() {
    }

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

    
}
