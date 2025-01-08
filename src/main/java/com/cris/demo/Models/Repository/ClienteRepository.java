package com.cris.demo.Models.Repository;

import com.cris.demo.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    List<Cliente> findByEstadoActivo(boolean estadoActivo);

}
