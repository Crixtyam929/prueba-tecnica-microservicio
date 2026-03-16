package com.tienda.tiendaservice.dto;

import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoRequestDto {

    @NotNull(message = "El cliente es obligatorio.")
    private Long clienteId;

    @Valid
    @NotEmpty(message = "El pedido debe tener al menos un producto.")
    private List<DetallePedidoDto> detalles;

}