package com.spring.cart.springbootangular.request;

import com.spring.cart.springbootangular.validation.UpdateByRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@UpdateByRole
public class UpdateByRoleRequest {

    private String idOfRole;

    private String roleOfRole;

    private String descriptionOfRole;
}
