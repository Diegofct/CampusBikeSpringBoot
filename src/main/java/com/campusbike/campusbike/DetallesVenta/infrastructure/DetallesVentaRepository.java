package com.campusbike.campusbike.DetallesVenta.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusbike.campusbike.DetallesVenta.domain.entity.DetallesVenta;


public interface DetallesVentaRepository extends JpaRepository<DetallesVenta, Long>{
    
}
