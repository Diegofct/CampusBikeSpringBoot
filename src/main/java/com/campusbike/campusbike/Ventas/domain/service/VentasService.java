package com.campusbike.campusbike.Ventas.domain.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.Ventas.domain.entity.Ventas;

public interface VentasService {
    void save(Ventas venta);
    void delete(Ventas venta);
    void update(Long id, Ventas venta);
    List<Ventas> findAll();
    Optional<Ventas> findById(Long id);
}
