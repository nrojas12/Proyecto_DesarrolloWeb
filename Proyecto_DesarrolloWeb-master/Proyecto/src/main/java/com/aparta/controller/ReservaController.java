/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aparta.controller;

import com.aparta.domain.Reserva;
import com.aparta.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.aparta.service.ReservaService;
import com.aparta.service.ReservaService;

@Controller
@Slf4j
@RequestMapping("/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reservas = reservaService.getreservas(false);
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalreserva", reservas.size());
        return "/reserva/listado";
    }
    
    @GetMapping("/nuevo")
    public String reservaNuevo(Reserva reserva) {
        return "/reserva/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            reservaService.save(reserva);
            reserva.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "reserva", 
                            reserva.getIdreserva()));
        }
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{idreserva}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{idreserva}")
    public String reservaModificar(Reserva reserva, Model model) {
        reserva = reservaService.getreserva(reserva);
        model.addAttribute("reserva", reserva);
        return "/reserva/modifica";
    }
}
