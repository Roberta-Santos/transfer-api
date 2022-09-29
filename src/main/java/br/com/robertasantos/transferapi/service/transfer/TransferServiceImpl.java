package br.com.robertasantos.transferapi.service.transfer;

import br.com.robertasantos.transferapi.domain.Client;
import br.com.robertasantos.transferapi.domain.Transfer;
import br.com.robertasantos.transferapi.repository.client.ClientRepository;
import br.com.robertasantos.transferapi.repository.transfer.TransferRepository;
import br.com.robertasantos.transferapi.service.client.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class );

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientServiceImpl clientService;

    @Override
    public Transfer makeTransfer(Transfer transfer) {
        Client originAccount = clientService.getByAccount(transfer.getOriginAccount());
        Client destinationAccount = clientService.getByAccount(transfer.getDestinationAccount());
        transfer = makeTransfer(originAccount, destinationAccount, transfer.getValue());
        transfer.setOriginAccount(String.valueOf(originAccount));
        transfer.setDestinationAccount(String.valueOf(destinationAccount));
        transfer.setTransferDate(LocalDate.now());
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    private Client debitValue(Client accountNumber, float value) {
        return debitValue(accountNumber, value);
    }

    private Client debitValue(Client originAccount, Client destinationAccount, float value) {
        if (value > 1000) {
            logger.info("Transferência inválida. O valor deve ser inferior a R$1000.");
        } else if (value > originAccount.getBalance()) {
            logger.info("A conta não possui saldo suficiente.");
        } else {
            originAccount.setBalance(originAccount.getBalance() - value);
            originAccount = clientRepository.save(originAccount);
        }
        return originAccount;
    }

    private Client creditValue(Client accountNumber, float value) {
        return creditValue(accountNumber, value);
    }

    private Client creditValue(Client originAccount, Client destinationAccount, float value) {
        if (value > originAccount.getBalance()) {
            logger.info("A conta não possui saldo suficiente.");
        } else {
            destinationAccount.setBalance(destinationAccount.getBalance() + value);
            destinationAccount = clientRepository.save(destinationAccount);
        }
        return destinationAccount;
    }

    private Transfer makeTransfer(Client originAccount, Client destinationAccount, float value) {
        Client debit = debitValue(originAccount, destinationAccount, value);
        Client credit = creditValue(originAccount, destinationAccount, value);
        return new Transfer();
    }
}
