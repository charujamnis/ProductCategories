package com.dtcc.projects.productcategories.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="categories_products")
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="products_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categories_id")
    private Category category;

    public Association(){}

    public Association(Product product, Category category) {
        this.product = product;
        this.category = category;
    }

    public Association(Long id, Product product, Category category) {
        this.id = id;
        this.product = product;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Association{" +
                "id=" + id +
                '}';
    }
}
