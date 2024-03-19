package com.alexandreTeste.awpag.api.controller;

import com.alexandreTeste.awpag.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("joao b");
        cliente1.setTelefone("11 93333 1111");
        cliente1.setEmail("joao@gmail.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("maria");
        cliente2.setTelefone("11 99999 4443");
        cliente2.setEmail("maria@gmail.com");

        return Arrays.asList(cliente1, cliente2);
     }
}
