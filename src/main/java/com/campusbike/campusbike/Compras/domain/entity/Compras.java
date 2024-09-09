package com.campusbike.campusbike.Compras.domain.entity;

import java.util.Date;

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
@Table(name="compras")
public class Compras {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @Column(name="fecha", columnDefinition="DATE")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id")
    private Proveedores proveedor_id;

    @Column(name="total", columnDefinition="DECIMAL(10,2)")
    private double total;

    public Compras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedores getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Proveedores proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
