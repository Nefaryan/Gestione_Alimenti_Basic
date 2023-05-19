package it.nttdata.gestionealimenti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private double price;
    private LocalDate expiryDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {}

    public Product(String name, String description, double price, LocalDate expiryDate, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expiryDate = expiryDate;
        this.category = category;
    }
}