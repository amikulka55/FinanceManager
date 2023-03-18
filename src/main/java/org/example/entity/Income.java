package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "Przychód")
public class Income {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
@Column(columnDefinition = "DECIMAL(9,2)")
private BigDecimal kwota;
@Column(name = "data_dodania")
private LocalDate dataDodania;

private String komentarz;

    public Income(BigDecimal kwota, BigDecimal bigDecimal, LocalDate dataDodania, String komentarz) {
        this.kwota = kwota;
        this.dataDodania = dataDodania;
        this.komentarz = komentarz;
    }
}
