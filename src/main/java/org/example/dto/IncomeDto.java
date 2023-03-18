package org.example.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class IncomeDto {

    private Integer Id;

    private BigDecimal kwota;

    private LocalDate dataDodania;

    private String komentarz;
}
