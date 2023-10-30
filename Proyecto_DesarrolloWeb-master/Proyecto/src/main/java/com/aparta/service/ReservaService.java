/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aparta.service;

import com.aparta.domain.Reserva;
import java.util.List;

public interface ReservaService {
    
    // Se obtiene un listado de reservas en un List
    public List<Reserva> getreservas(boolean activos);
    
   // Se obtiene un reserva, a partir del id de un reserva
    public Reserva getreserva(Reserva reserva);
    
    // Se inserta un nuevo reserva si el id del reserva esta vacío
    // Se actualiza un reserva si el id del reserva NO esta vacío
    public void save(Reserva reserva);
    
    // Se elimina el reserva que tiene el id pasado por parámetro
    public void delete(Reserva reserva);
}

