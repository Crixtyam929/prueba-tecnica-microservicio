package com.tienda.tiendaservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDto {

    private Long productoId;
    private Integer cantidad;

}