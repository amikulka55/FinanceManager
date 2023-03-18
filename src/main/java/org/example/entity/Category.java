package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.DBConnection;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@Entity
@ToString
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


}

