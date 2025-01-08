package com.cris.demo.Controllers;

import com.cris.demo.Models.Cliente;
import com.cris.demo.Models.User;
import com.cris.demo.Services.ClienteService;
import com.cris.demo.Security.payload.responses.Message;
import com.cris.demo.Security.payload.requests.ClienteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/lista")
    public List<Cliente> listaClientes() {
        return clienteService.listaClientesActivos();
    }

    @GetMapping("/listatodos")
    public List<Cliente> listaClientesTodos() {
        return clienteService.listaClientes();
    }

    @GetMapping("/consulta/{id}")
    public Optional<Cliente> consultaCliente(@PathVariable Integer id) {
        return clienteService.clientePorId(id);
    }

    // consulta producto
    /*@PostMapping("/consulta")
    public ResponseEntity<ProductoResponse> consultaProducto(@RequestBody ProductoRequest request) {
        return ResponseEntity.ok(service.consultaProducto(request));
    }*/

    @PostMapping("/save")
    public ResponseEntity<Message> productSave(@RequestBody ClienteRequest cliente, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(clienteService.clienteSave(cliente, user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> producUpdate(@PathVariable Integer id, @RequestBody ClienteRequest cliente, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(clienteService.clienteUpdate(id, cliente, user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> borrar(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(clienteService.clienteDelete(id, user));
    }
    
}
