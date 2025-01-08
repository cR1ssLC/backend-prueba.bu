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
public class CuentaRequest {
    
    private String tipoCuenta;
    private Integer nroCuenta;
    private String moneda;
    private float monto;
    private LocalDate fechaApertura;
    private String sucursal;
    private String modificadoPor;

}
