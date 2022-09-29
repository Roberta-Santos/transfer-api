package br.com.robertasantos.transferapi.controller.client;

import br.com.robertasantos.transferapi.domain.Client;
import br.com.robertasantos.transferapi.service.client.ClientServiceImpl;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Api(tags = "Clientes")
@RestController
public class ClientControllerImpl implements ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientControllerImpl.class);

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Client addClient(Client client) {
        logger.info("Cadastrando novo cliente.");
        return clientService.createClient(client);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Override
    public ResponseEntity<?> getClients() {
        List<Client> clients = clientService.getClients();
        logger.info("Listando clientes cadastrados.");
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping(path = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
@Override
    public Client getByAccount(@PathVariable String accountNumber) {
        logger.info("Buscando cliente pelo número da conta '{}'.", accountNumber);
        return clientService.getByAccount(accountNumber);
    }
}
