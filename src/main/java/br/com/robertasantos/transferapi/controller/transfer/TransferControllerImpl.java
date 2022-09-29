package br.com.robertasantos.transferapi.controller.transfer;

import br.com.robertasantos.transferapi.domain.Transfer;
import br.com.robertasantos.transferapi.service.transfer.TransferServiceImpl;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Api(tags = "Transferências")
@RestController
public class TransferControllerImpl implements TransferController {

    private static final Logger logger = LoggerFactory.getLogger(TransferControllerImpl.class);

    @Autowired
    private TransferServiceImpl transferService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Transfer makeTransfer(Transfer transfer) {
        logger.info("Realizando transferência no valor de: '{}' da conta origem: '{}' para a conta destino: '{}'.", transfer.getValue(), transfer.getOriginAccount(), transfer.getDestinationAccount());
        return transferService.makeTransfer(transfer);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> getTransfers() {
        List<Transfer> transfers = transferService.getTransfers();
        logger.info("Listando transferências realizadas.");
        return new ResponseEntity<>(transfers, HttpStatus.OK);
    }
}
