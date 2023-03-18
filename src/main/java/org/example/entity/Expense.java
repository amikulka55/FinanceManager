package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Wydatek")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(columnDefinition = "DECIMAL(9,2)")
    private BigDecimal kwota;
@Column(name = "data_dodania")
    private LocalDate dataDodania;

    private String komentarz;
@JoinColumn(name = "id_kategorii")
@ManyToOne

    private Category kategoria;



}
