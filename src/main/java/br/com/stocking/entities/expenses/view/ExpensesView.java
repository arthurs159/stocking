package br.com.stocking.entities.expenses.view;

import br.com.stocking.entities.expenses.Expenses;

import java.time.LocalDate;

public class ExpensesView {

    private Long id;

    private String name;

    private Double price;

    private LocalDate createdAt;

    public ExpensesView() {}

    public ExpensesView(Long id, String name, Double price, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public ExpensesView(Expenses expenses) {
        this.id = expenses.getId();
        this.name = expenses.getName();
        this.price = expenses.getPrice();
        this.createdAt = expenses.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
