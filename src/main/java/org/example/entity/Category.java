package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "Kategoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
@Column(length = 60, nullable = false)

    private String nazwa;

    public Category(Integer id, String nazwa) {
        Id = id;
        this.nazwa = nazwa;
    }

    public static boolean existByCategory(String categoryName) {
        return true;
    }
}

