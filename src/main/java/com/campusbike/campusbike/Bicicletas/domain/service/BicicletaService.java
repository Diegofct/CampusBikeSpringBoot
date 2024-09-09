package com.campusbike.campusbike.Bicicletas.domain.service;

import java.util.List;
import java.util.Optional;

import com.campusbike.campusbike.Bicicletas.domain.entity.Bicicletas;

public interface BicicletaService {
    void save(Bicicletas bicicleta);
    void delete(Bicicletas bicicleta);
    void update(Long id, Bicicletas bicicleta);
    List<Bicicletas> findAll();
    Optional<Bicicletas> findById(Long id);
}
