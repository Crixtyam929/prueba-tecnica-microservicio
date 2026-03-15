package com.tienda.tiendaservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoResponseDto {

    private Long id;
    private Long clienteId;
    private LocalDateTime fecha;
    private BigDecimal total;
    private List<DetallePedidoDto> detalles;

}