package br.com.robertasantos.transferapi.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id, gerado automaticamente pelo banco de dados")
    private Long id;

    @ApiModelProperty(notes = "Nome", example = "Roberta Fonseca Santos de Paula")
    private String name;

    @ApiModelProperty(notes = "Número da conta", example = "1234")
    private String accountNumber;

    @ApiModelProperty(notes = "Saldo da conta", example = "100.00")
    private float balance;
}
