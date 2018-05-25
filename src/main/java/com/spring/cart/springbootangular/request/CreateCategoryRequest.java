package com.spring.cart.springbootangular.request;

import com.spring.cart.springbootangular.validation.CreateNewCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateNewCategory
public class CreateCategoryRequest {

    private String nameOfCategory;
}
