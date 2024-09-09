package com.campusbike.campusbike.Proveedores.domain.entity;

import com.campusbike.campusbike.Ciudades.domain.entity.Ciudades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="proveedor_id")
    private Long id;

    @Column(name="nombre", columnDefinition="VARCHAR(100)")
    private String nombre;

    @Column(name="contacto", columnDefinition="BIGINT")
    private Long contacto;

    @Column(name="email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name="telefono", columnDefinition="BIGINT")
    private Long telefono;

    @ManyToOne
    @JoinColumn(name="ciudad_id")
    private Ciudades ciudad_id;

    public Proveedores() {
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

    public Long getContacto() {
        return contacto;
    }

    public void setContacto(Long contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Ciudades getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(Ciudades ciudad_id) {
        this.ciudad_id = ciudad_id;
    }


    


}
