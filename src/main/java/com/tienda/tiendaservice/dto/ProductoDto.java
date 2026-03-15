package com.tienda.tiendaservice.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;

}