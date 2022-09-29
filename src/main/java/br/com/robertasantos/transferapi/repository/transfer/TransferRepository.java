package br.com.robertasantos.transferapi.repository.transfer;

import br.com.robertasantos.transferapi.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
