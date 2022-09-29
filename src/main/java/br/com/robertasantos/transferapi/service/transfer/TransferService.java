package br.com.robertasantos.transferapi.service.transfer;

import br.com.robertasantos.transferapi.domain.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {

    Transfer makeTransfer(Transfer transfer);

    List<Transfer> getTransfers();
}
