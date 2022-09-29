package br.com.robertasantos.transferapi.dto;

import br.com.robertasantos.transferapi.domain.Client;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel(description = "Detalhes sobre o cliente.")
public class ClientDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    private String accountNumber;

    @Getter
    @Setter
    private float balance;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.accountNumber = client.getAccountNumber();
        this.balance = client.getBalance();
    }
}
