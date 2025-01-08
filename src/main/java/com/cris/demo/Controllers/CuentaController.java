package com.cris.demo.Controllers;

import com.cris.demo.Models.Cuenta;
import com.cris.demo.Security.payload.requests.CuentaRequest;
import com.cris.demo.Security.payload.responses.Message;
import org.springframework.http.ResponseEntity;
import com.cris.demo.Services.CuentaService;
import lombok.RequiredArgsConstructor;

// import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping("/lista")
    public List<Cuenta> findAll() {
        return cuentaService.findAll();
    }

    @PostMapping("/guardar/{id}")
    public ResponseEntity<Message> guardarCuenta(@RequestBody CuentaRequest cuentaRequest, @PathVariable Integer id) {
        return ResponseEntity.ok(cuentaService.guardarCuenta(cuentaRequest, id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Message> actualizarCuenta(@PathVariable Integer id, @RequestBody CuentaRequest cuentaRequest) {
        return ResponseEntity.ok(cuentaService.actualizarCuenta(id, cuentaRequest));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Message> eliminarCuenta(@PathVariable Integer id) {
        return ResponseEntity.ok(cuentaService.desactivarCuenta(id));
    }
    
}
