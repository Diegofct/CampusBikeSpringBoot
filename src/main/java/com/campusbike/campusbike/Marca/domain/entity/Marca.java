package com.campusbike.campusbike.Marca.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marca")
public class Marca {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="marca_id")
    private Long id;

    @Column(name="nombre", columnDefinition="VARCHAR(100)")
    private String nombre;

    public Marca() {
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

    
}
