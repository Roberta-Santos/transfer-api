package br.com.robertasantos.transferapi.controller.client;

import br.com.robertasantos.transferapi.domain.Client;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/")
public interface ClientController {

    @ApiOperation(value = "Cadastro de um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = Client.class, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    Client addClient(@RequestBody Client client);

    @ApiOperation(value = "Lista todos os clientes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Client.class, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> getClients();

    @ApiOperation(value = "Busca um cliente pelo número da conta")
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = Client.class, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    Client getByAccount(@ApiParam(value = "Número da conta", required = true) @PathVariable(value = "accountNumber") String accountNumber);
}
