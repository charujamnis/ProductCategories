package com.dtcc.projects.productcategories.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="is required")
    @NotBlank(message="can not be empty")
    private String name;
    private String description;
    private double price;

    @Column(name="created_at")
    private Date createdate;

    @Column(name="updated_at")
    private Date updatedate;

   // @ManyToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
   // private List <Category> categories;

    @ManyToMany
    @JoinTable(
               name="categories_products",
               joinColumns = @JoinColumn(name="products_id"),
               inverseJoinColumns = @JoinColumn(name="categories_id")
               )
    private List <Category> categories;

    public Product() {}


    public Product(@NotNull(message = "is required") @NotBlank(message = "can not be empty") String name, String description, double price, Date createdate, Date updatedate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
