package com.cris.demo.Models.Repository;

import com.cris.demo.Models.Cuenta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

//    @Query(value="""
//            select a from Cuenta a\s
//            where a.cliente_id = :id\s
//            and a.estadoActivo = true\s  
//            """)
    Optional<Cuenta> findByClienteId (Integer id);

    @Query(value="""
            select count(a) from Cuenta a\s
            where a.estadoActivo = true\s
            """)
    Integer contar();
    
}
