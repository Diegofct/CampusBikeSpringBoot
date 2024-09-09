package com.campusbike.campusbike.DetallesVenta.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.campusbike.campusbike.DetallesVenta.domain.entity.DetallesVenta;
import com.campusbike.campusbike.DetallesVenta.domain.service.DetallesVentaService;
import com.campusbike.campusbike.DetallesVenta.infrastructure.DetallesVentaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public class DetallesVentaServiceImpl implements DetallesVentaService{
    
    @Autowired
    DetallesVentaRepository detallesVentaRepository;

    @Override
    @Transactional
    public void save(DetallesVenta detallesVenta ) {
        detallesVentaRepository.save(detallesVenta);
    }

    @Override
    @Transactional
    public void delete(DetallesVenta detallesVenta ) {
        detallesVentaRepository.delete(detallesVenta);
    }

    @Override
    @Transactional
    public void update(Long id, DetallesVenta detallesVenta) {
        Optional<DetallesVenta> existingDetallesVenta = detallesVentaRepository.findById(detallesVenta.getId());

        if (existingDetallesVenta.isPresent()){
            DetallesVenta foundDetallesVenta = existingDetallesVenta.get();

            foundDetallesVenta.setBicicleta_id(detallesVenta.getBicicleta_id());
            foundDetallesVenta.setVenta_id(detallesVenta.getVenta_id());
            foundDetallesVenta.setCantidad(detallesVenta.getCantidad());
            foundDetallesVenta.setPrecio_unitario(detallesVenta.getPrecio_unitario());
            detallesVentaRepository.save(detallesVenta);

        } else {
        throw new EntityNotFoundException("Detalle de la  venta con id:  " + id + " no fue encontrada");
        }
    }

    @Override
    @Transactional
    public List<DetallesVenta> findAll() {
        return detallesVentaRepository.findAll();
    }

    @Override
    public Optional<DetallesVenta> findById(Long id) {
        return detallesVentaRepository.findById(id);
    }
}
