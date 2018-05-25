package com.spring.cart.springbootangular.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idproduct;

    @Column(name = "name", nullable = false)
    private String name;

    @Max(10)
    @Min(1)
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;
}
