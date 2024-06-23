package com.comercio.registroDeVentas.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends EntidadBase{

    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private Double precioMayorista;
}
