package com.cris.demo.Services;

import com.cris.demo.Models.Repository.ClienteRepository;
import com.cris.demo.Models.User;
import com.cris.demo.Models.Cliente;
import com.cris.demo.Security.payload.requests.ClienteRequest;
import com.cris.demo.Security.payload.responses.Message;
//import com.yumara.backendpg.Security.payload.response.ProductoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Optional<Cliente> clientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listaClientesActivos() {
        return clienteRepository.findByEstadoActivo(true);
    }

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    /*public ProductoResponse consultaProducto (ProductoRequest request) {
        var producto = productoRepository.findByCodigoBarra(request.getCodigoBarra());
        return ProductoResponse.builder()
                .id(producto.getIdProducto())
                .descripcion(producto.getDescripcionProducto())
                .precioUnitario(producto.getPrecioUnitario())
                .codBarra(producto.getCodigoBarra())
                .build();
    }*/

    public Message clienteSave(ClienteRequest cliente, User user) {
        Cliente client = new Cliente();
        client.setNombres(cliente.getNombres());
        client.setApPaterno(cliente.getApPaterno());
        client.setApMaterno(cliente.getApMaterno());
        client.setTipoDocumento(cliente.getTipoDocumento());
        client.setDocumentoIdentidad(cliente.getDocumentoIdentidad());
        client.setFechaNacimiento(cliente.getFechaNacimiento());
        client.setGenero(cliente.getGenero());
        client.setEstadoActivo(true);
        client.setFechaModificacion(LocalDate.now());
        var name = user.getUsername();
        client.setModificadoPor(name);
        clienteRepository.save(client);
        return Message.builder()
                .status("success")
                .message("Cliente guardado con exito")
                .build();
    }

    public Message clienteUpdate(Integer id, ClienteRequest cliente, User user) {
        Cliente client = clienteRepository.findById(id).orElseThrow();
        client.setNombres(cliente.getNombres());
        client.setApPaterno(cliente.getApPaterno());
        client.setApMaterno(cliente.getApMaterno());
        client.setTipoDocumento(cliente.getTipoDocumento());
        client.setDocumentoIdentidad(cliente.getDocumentoIdentidad());
        client.setFechaNacimiento(cliente.getFechaNacimiento());
        client.setGenero(cliente.getGenero());
        client.setFechaModificacion(LocalDate.now());
        var name = user.getUsername();
        client.setModificadoPor(name);
        client.setEstadoActivo(true);
        clienteRepository.save(client);
        return Message.builder()
                .status("success")
                .message("Cliente actualizado con exito")
                .build();
    }

    public Message clienteDelete(Integer id, User user) {
        // clienteRepository.deleteById(id);
        Cliente client = clienteRepository.findById(id).orElseThrow();
        client.setEstadoActivo(false);
        client.setFechaModificacion(LocalDate.now());
        var name = user.getUsername();
        client.setModificadoPor(name);
        clienteRepository.save(client);
        return Message.builder()
                .status("success")
                .message("Cliente eliminado con exito")
                .build();
    }
}
