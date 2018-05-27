package com.spring.cart.springbootangular.controller;

import com.spring.cart.springbootangular.entity.Product;
import com.spring.cart.springbootangular.request.CreateProductRequest;
import com.spring.cart.springbootangular.request.GetDetailsByProductRequest;
import com.spring.cart.springbootangular.response.ErrorReponse;
import com.spring.cart.springbootangular.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> listProduct(){
        return Optional.ofNullable(productService.listProduct())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductRequest request){
        return Optional.ofNullable(productService.createdProduct(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Product>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Optional<Product>> getDetails(@PathVariable String productId){
        GetDetailsByProductRequest request = GetDetailsByProductRequest
                .builder().productId(productId)
                .build();

        Optional<Product> product = productService.getDetailProduct(request);
        if(!product.isPresent()){
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorReponse handlingException(MethodArgumentNotValidException exception){

        String errorMessages = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorReponse
                .builder()
                .message(errorMessages)
                .status(false)
                .dateTime(new Date())
                .build();
    }
}
