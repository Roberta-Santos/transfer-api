package br.com.robertasantos.transferapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TRANSFER")
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ApiModelProperty(notes = "Número da conta de origem", example = "1234")
    private String originAccount ;

    @ApiModelProperty(notes = "Número da conta de destino", example = "1234")
    private String destinationAccount;

    @ApiModelProperty(notes = "Saldo a ser transferido", example = "100.00")
    private float value;

    @ApiModelProperty(notes = "Data da transferência", example = "2020-10-20")
    private LocalDate transferDate;
}
