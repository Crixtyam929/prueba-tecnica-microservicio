package com.tienda.tiendaservice.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoRequestDto {

    private Long clienteId;
    private List<DetallePedidoDto> detalles;

}