package br.com.stocking.entities.expenses;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@Entity
public class Expenses implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private final LocalDate createdAt = now();

    public Expenses() {
    }

    public Expenses(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
