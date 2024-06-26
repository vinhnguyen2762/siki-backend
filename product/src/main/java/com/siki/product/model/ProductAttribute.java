package com.siki.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_attribute")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productAttribute", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<ProductAttributeValue> productAttributeValues = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "base_product_id")
    private BaseProduct baseProduct;
}
