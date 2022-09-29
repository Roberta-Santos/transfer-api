package br.com.robertasantos.transferapi.service.client;

import br.com.robertasantos.transferapi.domain.Client;
import br.com.robertasantos.transferapi.repository.client.ClientRepository;
import br.com.robertasantos.transferapi.repository.client.ClientRepositoryCustomImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepositoryCustomImpl clientRepositoryImpl;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void addClient() {
        Client client = new Client();
        client.setId(12345L);
        client.setName("Roberta");
        client.setAccountNumber("1234");
        client.setBalance(1000);

        clientRepository.save(client);

        assertThat(client.getId()).isEqualTo(12345);
        assertThat(client.getName()).isEqualTo("Roberta");
        assertThat(client.getAccountNumber()).isEqualTo("1234");
        assertThat(client.getBalance()).isEqualTo(1000);
    }

    @Test
    public void getClients() {
        Client client1 = new Client();
        Client client2 = new Client();
        client1.setId(12345L);
        client1.setName("Roberta");
        client1.setAccountNumber("1234");
        client1.setBalance(1000);

        client2.setId(54321L);
        client2.setName("Leonardo");
        client2.setAccountNumber("4321");
        client2.setBalance(1500);

        List<Client> clientResponse = new ArrayList<>();
        clientResponse.add(client1);
        clientResponse.add(client2);

        clientRepository.findAll();

        assertThat(client1.getId()).isEqualTo(clientResponse.get(0).getId());
        assertThat(client1.getName()).isEqualTo(clientResponse.get(0).getName());
        assertThat(client1.getAccountNumber()).isEqualTo(clientResponse.get(0).getAccountNumber());
        assertThat(client1.getBalance()).isEqualTo(clientResponse.get(0).getBalance());
        assertThat(client2.getId()).isEqualTo(clientResponse.get(1).getId());
        assertThat(client2.getName()).isEqualTo(clientResponse.get(1).getName());
        assertThat(client2.getAccountNumber()).isEqualTo(clientResponse.get(1).getAccountNumber());
        assertThat(client2.getBalance()).isEqualTo(clientResponse.get(1).getBalance());
    }

    @Test
    public void getByAccountNumber() {
        Client client = new Client();
        client.setId(12345L);
        client.setName("Roberta");
        client.setAccountNumber("1234");
        client.setBalance(1000);

        clientRepositoryImpl.findById(client.getAccountNumber());

        assertThat(client.getId()).isEqualTo(12345);
        assertThat(client.getName()).isEqualTo("Roberta");
        assertThat(client.getAccountNumber()).isEqualTo("1234");
        assertThat(client.getBalance()).isEqualTo(1000);
    }
}
