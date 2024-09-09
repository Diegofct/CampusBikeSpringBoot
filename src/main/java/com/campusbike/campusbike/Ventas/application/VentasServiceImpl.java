package com.campusbike.campusbike.Ventas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.Ventas.domain.entity.Ventas;
import com.campusbike.campusbike.Ventas.domain.service.VentasService;
import com.campusbike.campusbike.Ventas.infrastructure.VentasRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VentasServiceImpl implements VentasService{
    
    @Autowired
    VentasRepository ventasRepository;

    @Override
    @Transactional
    public void save(Ventas venta ) {
        ventasRepository.save(venta);
    }

    @Override
    @Transactional
    public void delete(Ventas venta ) {
        ventasRepository.delete(venta);
    }

    @Override
    @Transactional
    public void update(Long id, Ventas venta) {
        Optional<Ventas> existingVenta = ventasRepository.findById(venta.getId());

        if (existingVenta.isPresent()){
            Ventas foundVenta = existingVenta.get();

            foundVenta.setFecha(venta.getFecha());
            foundVenta.setCliente_id(venta.getCliente_id());
            ventasRepository.save(venta);

        } else {
        throw new EntityNotFoundException("Venta con id:  " + id + " no fue encontrada");
        }
    }

    @Override
    @Transactional
    public List<Ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public Optional<Ventas> findById(Long id) {
        return ventasRepository.findById(id);
    }

}
