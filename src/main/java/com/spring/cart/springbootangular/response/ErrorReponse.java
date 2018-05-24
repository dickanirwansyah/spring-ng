package com.spring.cart.springbootangular.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorReponse {

    private String message;

    private boolean status;

    private Date dateTime;
}
