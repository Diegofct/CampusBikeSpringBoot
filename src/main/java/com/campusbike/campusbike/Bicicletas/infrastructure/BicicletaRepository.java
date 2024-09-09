package com.campusbike.campusbike.Bicicletas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusbike.campusbike.Bicicletas.domain.entity.Bicicletas;

public interface BicicletaRepository extends JpaRepository<Bicicletas, Long>{
    
}
