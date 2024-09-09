package com.campusbike.campusbike.Clientes.domain.entity;

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
@Table(name="clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long id;

    @Column(name="nombre", columnDefinition="VARCHAR(100)")
    private String nombre;

    @Column(name="email", columnDefinition="VARCHAR(100)")
    private String email;

    @Column(name="telefono", columnDefinition="BIGINT")
    private Long telefono;

    @Column(name="password", columnDefinition="VARCHAR(100)")
    private String password;

    @ManyToOne
    @JoinColumn(name="ciudad_id")
    private Ciudades ciudad_id;

    public Clientes() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ciudades getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(Ciudades ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

}
