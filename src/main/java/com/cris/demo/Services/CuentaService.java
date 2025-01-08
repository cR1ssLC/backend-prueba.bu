package com.cris.demo.Services;

import com.cris.demo.Models.Cuenta;
import com.cris.demo.Models.Cliente;
import com.cris.demo.Models.Repository.CuentaRepository;
import com.cris.demo.Models.Repository.ClienteRepository;
import com.cris.demo.Security.payload.requests.CuentaRequest;
import com.cris.demo.Security.payload.responses.Message;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Message guardarCuenta (CuentaRequest cuentaRequest, Integer id) {
        Cliente cliente = clienteRepository.findById(id).get();
        Cuenta cuenta = new Cuenta();
        cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
        cuenta.setNroCuenta(cuentaRepository.contar() == 0 ? 1 : cuentaRepository.contar() + 1 );
        cuenta.setMoneda(cuentaRequest.getMoneda());
        cuenta.setMonto(cuentaRequest.getMonto() != 0 ? cuentaRequest.getMonto() : 0);
        cuenta.setFechaApertura(LocalDate.now());
        cuenta.setSucursal(cuentaRequest.getSucursal());
        cuenta.setModificadoPor(cuentaRequest.getModificadoPor());
        cuenta.setFechaModificacion(LocalDate.now());
        cuenta.setEstadoActivo(true);
        cuenta.setCliente(cliente);
        //cuentaRepository.save(cuenta);
        //cliente.setCuentas(cuenta);
        cuentaRepository.save(cuenta);
        clienteRepository.save(cliente);
        return Message.builder()
        .status("success")
        .message("Cuenta registrada con exito")
        .build();
    }

    public Message actualizarCuenta (Integer idCuenta, CuentaRequest cuentaRequest) {
        Cuenta cuenta = cuentaRepository.findById(idCuenta).get();
        cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
        cuenta.setMoneda(cuentaRequest.getMoneda());
        cuenta.setMonto(cuentaRequest.getMonto());
        cuenta.setSucursal(cuentaRequest.getSucursal());
        cuenta.setFechaModificacion(LocalDate.now());
        cuenta.setModificadoPor(cuentaRequest.getModificadoPor());
        cuentaRepository.save(cuenta);
        return Message.builder()
        .status("success")
        .message("Cuenta actualizada con exito")
        .build();
    }

    public Message desactivarCuenta (Integer id) {
        // cuentaRepository.deleteById(id);
        Cuenta cuenta = cuentaRepository.findById(id).get();
        cuenta.setEstadoActivo(false);
        cuentaRepository.save(cuenta);
        return Message.builder()
        .status("success")
        .message("Cuenta eliminada con exito")
        .build();
    }
    
}
