package br.com.robertasantos.transferapi.service.client;

import br.com.robertasantos.transferapi.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    Client createClient(Client client);

    List<Client> getClients();

    Client getByAccount(String accountNumber);

}