package com.aparta.dao;


import com.aparta.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaDao extends JpaRepository <Reserva, Long>{
    
}
