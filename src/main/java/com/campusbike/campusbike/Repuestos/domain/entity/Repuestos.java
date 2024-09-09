package com.campusbike.campusbike.Repuestos.domain.entity;

import com.campusbike.campusbike.Marca.domain.entity.Marca;
import com.campusbike.campusbike.Modelo.domain.entity.Modelo;
import com.campusbike.campusbike.Proveedores.domain.entity.Proveedores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="repuestos")
public class Repuestos {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="repuesto_id")
    private Long id;

    @Column(name="nombre", columnDefinition = "VARCHAR(100)")
    private String nombre;

    @Column(name="descripcion", columnDefinition="VARCHAR(200)")
    private String descripcion;

    @Column(name="precio", columnDefinition="DECIMAL(10,2)")
    private double precio;

    @Column(name="stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name="proveedor_id")
    private Proveedores proveedor_id;

    @ManyToOne
    @JoinColumn(name="modelo_id")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    public Repuestos() {
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

    public Proveedores getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Proveedores proveedor_id) {
        this.proveedor_id = proveedor_id;
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

    
}
