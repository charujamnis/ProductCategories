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
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="is required")
    @NotBlank(message="can not be empty")
    private String name;

    @Column(name="created_at")
    private Date createdate;

    @Column(name="updated_at")
    private Date updatedate;
  //  @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
  //  private List<Product> products;
    @ManyToMany
    @JoinTable(
            name="categories_products",
            joinColumns = @JoinColumn(name="categories_id"),
            inverseJoinColumns = @JoinColumn(name="products_id")
            )
    private List<Product> products;

   public Category(){}

    public Category(@NotNull(message = "is required") @NotBlank(message = "can not be empty") String name, Date createdate, Date updatedate) {
        this.name = name;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    public Category(Long id, @NotNull(message = "is required") @NotBlank(message = "can not be empty") String name, Date createdate, Date updatedate) {
        this.id = id;
        this.name = name;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
