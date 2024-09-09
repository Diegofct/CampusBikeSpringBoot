package com.campusbike.campusbike.DetallesCompra.domain.entity;

import com.campusbike.campusbike.Compras.domain.entity.Compras;
import com.campusbike.campusbike.Repuestos.domain.entity.Repuestos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalles_compras")
public class DetallesCompra {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="compra_id")
    private Compras compra_id;

    @ManyToOne
    @JoinColumn(name="repuesto_id")
    private Repuestos repuesto_id;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name="precio_unitario", columnDefinition = "DECIMAL(10,2)")
    private double precio_unitario;

    public DetallesCompra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compras getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(Compras compra_id) {
        this.compra_id = compra_id;
    }

    public Repuestos getRepuesto_id() {
        return repuesto_id;
    }

    public void setRepuesto_id(Repuestos repuesto_id) {
        this.repuesto_id = repuesto_id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    
}
