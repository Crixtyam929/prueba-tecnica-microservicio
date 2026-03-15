package com.tienda.tiendaservice.exception;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

    private String mensaje;
    private int status;
    private LocalDateTime timestamp;

}