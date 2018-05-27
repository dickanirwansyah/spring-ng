package com.spring.cart.springbootangular.request;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.validation.CreateNewProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateNewProduct
public class CreateProductRequest {

    private String nameOfProduct;

    private Integer stockOfProduct;

    private Integer priceOfProduct;

    private Category categoryOfProduct;
}
