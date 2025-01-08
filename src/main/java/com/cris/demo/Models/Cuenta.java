package com.cris.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoCuenta;
    private Integer nroCuenta;
    private String moneda;
    private float monto;
    private LocalDate fechaApertura;
    private String sucursal;

    private String modificadoPor;
    private LocalDate fechaModificacion;
    private boolean estadoActivo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    //@OneToMany(mappedBy = "cuentas")
    //private Set<Cliente> cliente;
    
}
