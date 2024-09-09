package com.campusbike.campusbike.Bicicletas.domain.entity;

import com.campusbike.campusbike.Marca.domain.entity.Marca;
import com.campusbike.campusbike.Modelo.domain.entity.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bicicletas")
public class Bicicletas {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bicicleta_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    @Column(name="precio", columnDefinition="DECIMAL(10,2)")
    private double precio;

    @Column(name="stock")
    private int stock;

    public Bicicletas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
