package br.com.robertasantos.transferapi.controller.transfer;

import br.com.robertasantos.transferapi.domain.Transfer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public interface TransferController {

    @ApiOperation(value = "Transferência entre duas contas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = Transfer.class, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    Transfer makeTransfer(@RequestBody Transfer transfer);

    @ApiOperation(value = "Lista todas as transferências realizadas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = Transfer.class, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> getTransfers();
}
