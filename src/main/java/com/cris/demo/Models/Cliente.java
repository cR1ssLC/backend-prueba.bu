package com.cris.demo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private String tipoDocumento;
    private String documentoIdentidad;
    private LocalDate fechaNacimiento;
    private String genero;
    
    private String modificadoPor;
    private LocalDate fechaModificacion;
    private boolean estadoActivo;

    @OneToMany(mappedBy = "cliente")
    private Set<Cuenta> cuentas;

    //@ManyToOne
    //@JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    //private Cuenta cuentas;
}
