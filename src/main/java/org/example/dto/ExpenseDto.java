package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExpenseDto {
    private Integer Id;

    private BigDecimal kwota;

    private LocalDate dataDodania;

    private String komentarz;

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "Id=" + Id +
                ", kwota=" + kwota +
                ", dataDodania=" + dataDodania +
                ", komentarz='" + komentarz + '\'' +
                '}';
    }
}
