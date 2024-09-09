package com.campusbike.campusbike.Ventas.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusbike.campusbike.Ventas.domain.entity.Ventas;

public interface VentasRepository  extends JpaRepository<Ventas, Long>{
    
}
