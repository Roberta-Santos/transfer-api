package br.com.robertasantos.transferapi.repository.client;

import br.com.robertasantos.transferapi.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom {
}
