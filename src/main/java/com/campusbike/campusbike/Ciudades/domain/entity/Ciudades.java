package com.campusbike.campusbike.Ciudades.domain.entity;

import com.campusbike.campusbike.Paises.domain.entity.Paises;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ciudades")
public class Ciudades {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ciudad_id")
    private Long id;

    @Column(name="nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="id")
    private Paises paises;

    public Ciudades() {
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

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

    

}
