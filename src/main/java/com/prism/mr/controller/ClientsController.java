package com.prism.mr.controller;

import com.prism.mr.dto.ClientsDto;
import com.prism.mr.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientsController {
    private final ClientService clientService;
    @PostMapping("/clients")
    public ResponseEntity<ClientsDto> addOrUpdateClient(@RequestBody ClientsDto clientsDto) {
        return new ResponseEntity<>(clientService.addOrUpdateClient(clientsDto), HttpStatus.OK);
    }

    @GetMapping("/clients/validate/clientCode")
    public ResponseEntity<String> validateClientCode(@RequestParam(required = false) Long Id, @RequestParam String Code) {
        return new ResponseEntity<>(clientService.validateClientCode(Id,Code), HttpStatus.OK);
    }
}
