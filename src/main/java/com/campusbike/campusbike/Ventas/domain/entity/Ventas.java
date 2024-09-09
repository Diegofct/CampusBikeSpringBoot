package com.campusbike.campusbike.Ventas.domain.entity;

import java.util.Date;

import com.campusbike.campusbike.Clientes.domain.entity.Clientes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="venta_id")
    private Long id;

    @Column(name="fecha", columnDefinition="DATE")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Clientes cliente_id;

    public Ventas() {
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

    public Clientes getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Clientes cliente_id) {
        this.cliente_id = cliente_id;
    }
    
}
