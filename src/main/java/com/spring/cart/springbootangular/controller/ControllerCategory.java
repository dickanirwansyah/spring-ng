package com.spring.cart.springbootangular.controller;

import com.spring.cart.springbootangular.entity.Category;
import com.spring.cart.springbootangular.request.CreateCategoryRequest;
import com.spring.cart.springbootangular.request.GetDetailsByCategoryRequest;
import com.spring.cart.springbootangular.response.ErrorReponse;
import com.spring.cart.springbootangular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/category")
public class ControllerCategory {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{idcategory}")
    public ResponseEntity<Optional<Category>> findCategoryId(@PathVariable String idcategory){

        GetDetailsByCategoryRequest request = GetDetailsByCategoryRequest
                .builder()
                .categoryId(idcategory)
                .build();
        /**
         * isPresent() sama seperti menampilkan data.
         **/
        Optional<Category> category = categoryService.findByCategoryId(request);
        if(!category.isPresent()){
            return new ResponseEntity<Optional<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Category>>(category, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryRequest request){
        return Optional.ofNullable(categoryService.createNewCategory(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Category>(HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorReponse handlingException(MethodArgumentNotValidException exception){

        String errorMsg = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return ErrorReponse
                .builder().message(errorMsg)
                .status(false)
                .dateTime(new Date())
                .build();
    }
}
