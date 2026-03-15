package com.tienda.tiendaservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;

}