package com.campusbike.campusbike.DetallesVenta.domain.entity;

import com.campusbike.campusbike.Bicicletas.domain.entity.Bicicletas;
import com.campusbike.campusbike.Ventas.domain.entity.Ventas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalles_ventas")
public class DetallesVenta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="venta_id")
    private Ventas venta_id;

    @ManyToOne
    @JoinColumn(name="bicicleta_id")
    private Bicicletas bicicleta_id;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="precio_unitario", columnDefinition="DECIMAL(10,2)")
    private double precio_unitario;

    public DetallesVenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ventas getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(Ventas venta_id) {
        this.venta_id = venta_id;
    }

    public Bicicletas getBicicleta_id() {
        return bicicleta_id;
    }

    public void setBicicleta_id(Bicicletas bicicleta_id) {
        this.bicicleta_id = bicicleta_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    



}
