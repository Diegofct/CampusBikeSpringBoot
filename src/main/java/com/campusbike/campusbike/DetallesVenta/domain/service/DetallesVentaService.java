package com.campusbike.campusbike.DetallesVenta.domain.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.DetallesVenta.domain.entity.DetallesVenta;

public interface DetallesVentaService {
    void save(DetallesVenta detallesVenta);
    void delete(DetallesVenta detallesVenta);
    void update(Long id, DetallesVenta detallesVenta);
    List<DetallesVenta> findAll();
    Optional<DetallesVenta> findById(Long id);
}
