package com.cris.demo.Security.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String tipoDocumento;
    private String documentoIdentidad;
    private LocalDate fechaNacimiento;
    private String genero;
    
}
