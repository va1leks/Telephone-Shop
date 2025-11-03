package com.example.telephoneshop.controllers;

import com.example.telephoneshop.dto.ClientDto;
import com.example.telephoneshop.entity.Client;
import com.example.telephoneshop.entity.Telephone;
import com.example.telephoneshop.service.impl.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("telshop/")
public class ClientController {

    public ClientServiceImpl clientService;

    @GetMapping("{id}")
    Optional<Client> findById(@PathVariable long id) {
        return clientService.GetClientById(id);
    }

    @PostMapping("/retister")
    Client CreateClient(@RequestBody ClientDto client) {
        return clientService.CreateClient(client);
    }

    @GetMapping("/cart/{id}")
    List<Telephone> GetTelephonesFromCart(@PathVariable long ClientId) {
        return clientService.GetTelephonesFromCart(ClientId);
    }
}
