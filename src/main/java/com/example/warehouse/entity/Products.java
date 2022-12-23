package com.example.warehouse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please fill Name")
    @Length(max = 2048, message = "Name too long (more than 2kB)")
    private String name;

    @Length(max = 2048, message = "Description too long (more than 2kB)")
    private String description;

    @Length(max = 2048, message = "Brand too long (more than 2kB)")
    private String brand;

    public Products(String name, String description, String brand) {
        this.name = name;
        this.description = description;
        this.brand = brand;
    }
}
