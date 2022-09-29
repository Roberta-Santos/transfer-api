package br.com.robertasantos.transferapi.service.client;

import br.com.robertasantos.transferapi.domain.Client;
import br.com.robertasantos.transferapi.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getByAccount(String accountNumber) {
        return clientRepository.findById(accountNumber);
    }
}
