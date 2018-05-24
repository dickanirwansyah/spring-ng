package com.spring.cart.springbootangular.request;

import com.spring.cart.springbootangular.validation.CreateNewRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CreateNewRole
public class CreateRoleRequest {

    private String roleOfRole;

    private String descriptionOfRole;
}
