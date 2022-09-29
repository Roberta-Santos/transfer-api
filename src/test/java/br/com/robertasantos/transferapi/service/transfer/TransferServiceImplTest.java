package br.com.robertasantos.transferapi.service.transfer;

import br.com.robertasantos.transferapi.domain.Transfer;
import br.com.robertasantos.transferapi.repository.transfer.TransferRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TransferServiceImplTest {

    @InjectMocks
    private TransferServiceImpl transferService;

    @Mock
    private TransferRepository transferRepository;

    @Test
    public void makeTransfer() {
        Transfer transfer = new Transfer();
        transfer.setId(12345L);
        transfer.setOriginAccount("1234");
        transfer.setDestinationAccount("4321");
        transfer.setValue(1000);
        transfer.setTransferDate(LocalDate.now());

        transferRepository.save(transfer);

        assertThat(transfer.getId()).isEqualTo(12345);
        assertThat(transfer.getOriginAccount()).isEqualTo("1234");
        assertThat(transfer.getDestinationAccount()).isEqualTo("4321");
        assertThat(transfer.getValue()).isEqualTo(1000);
        assertThat(transfer.getTransferDate()).isEqualTo(LocalDate.now());
    }

@Test
    public void getTransfers() {
        Transfer transfer1 = new Transfer();
        Transfer transfer2 = new Transfer();
    transfer1.setId(12345L);
    transfer1.setOriginAccount("1234");
    transfer1.setDestinationAccount("4321");
    transfer1.setValue(1000);
    transfer1.setTransferDate(LocalDate.now());

    transfer2.setId(54321L);
    transfer2.setOriginAccount("5678");
    transfer2.setDestinationAccount("8765");
    transfer2.setValue(100);
    transfer2.setTransferDate(LocalDate.now());

    List<Transfer> transferResponse = new ArrayList<>();
    transferResponse.add(transfer1);
    transferResponse.add(transfer2);

    transferRepository.findAll();

    assertThat(transfer1.getId()).isEqualTo(transferResponse.get(0).getId());
    assertThat(transfer1.getOriginAccount()).isEqualTo(transferResponse.get(0).getOriginAccount());
    assertThat(transfer1.getDestinationAccount()).isEqualTo(transferResponse.get(0).getDestinationAccount());
    assertThat(transfer1.getValue()).isEqualTo(transferResponse.get(0).getValue());
    assertThat(transfer1.getTransferDate()).isEqualTo(transferResponse.get(0).getTransferDate());
    assertThat(transfer2.getId()).isEqualTo(transferResponse.get(1).getId());
    assertThat(transfer2.getOriginAccount()).isEqualTo(transferResponse.get(1).getOriginAccount());
    assertThat(transfer2.getDestinationAccount()).isEqualTo(transferResponse.get(1).getDestinationAccount());
    assertThat(transfer2.getValue()).isEqualTo(transferResponse.get(1).getValue());
    assertThat(transfer2.getTransferDate()).isEqualTo(transferResponse.get(1).getTransferDate());
}
}
