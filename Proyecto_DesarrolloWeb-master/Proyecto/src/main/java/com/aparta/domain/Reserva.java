
package com.aparta.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "reserva")

public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_reserva")
    private long idreserva;

    
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    public Reserva(){
    }
    
   public Reserva( String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
            
    
    
    
    
}
