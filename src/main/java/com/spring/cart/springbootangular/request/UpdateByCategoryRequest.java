package com.spring.cart.springbootangular.request;

import com.spring.cart.springbootangular.validation.UpdateByCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UpdateByCategory
public class UpdateByCategoryRequest {

    private String categoryId;

    private String nameOfCategory;
}
