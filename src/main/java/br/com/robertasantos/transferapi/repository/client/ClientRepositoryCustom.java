package br.com.robertasantos.transferapi.repository.client;

import br.com.robertasantos.transferapi.domain.Client;

public interface ClientRepositoryCustom {
Client findById(String accountNumber);
}
