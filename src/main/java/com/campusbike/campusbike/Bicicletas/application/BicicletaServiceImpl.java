package com.campusbike.campusbike.Bicicletas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusbike.campusbike.Bicicletas.domain.entity.Bicicletas;
import com.campusbike.campusbike.Bicicletas.domain.service.BicicletaService;
import com.campusbike.campusbike.Bicicletas.infrastructure.BicicletaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BicicletaServiceImpl implements BicicletaService{
    @Autowired
    BicicletaRepository bicicletaRepository;

    @Override
    @Transactional
    public void save(Bicicletas bicicleta ) {
        bicicletaRepository.save(bicicleta);
    }

    @Override
    @Transactional
    public void delete(Bicicletas bicicleta ) {
        bicicletaRepository.delete(bicicleta);
    }

    @Override
    @Transactional
    public void update(Long id, Bicicletas bicicleta) {
        Optional<Bicicletas> existingBicicleta = bicicletaRepository.findById(bicicleta.getId());

        if (existingBicicleta.isPresent()){
            Bicicletas foundbicicleta = existingBicicleta.get();

            foundbicicleta.setMarca(bicicleta.getMarca()); 
            foundbicicleta.setModelo(bicicleta.getModelo());           
            foundbicicleta.setPrecio(bicicleta.getPrecio());
            foundbicicleta.setStock(bicicleta.getStock());
            bicicletaRepository.save(bicicleta);

        } else {
        throw new EntityNotFoundException("Bike not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public List<Bicicletas> findAll() {
        return bicicletaRepository.findAll();
    }

    @Override
    public Optional<Bicicletas> findById(Long id) {
        return bicicletaRepository.findById(id);
    }
}
