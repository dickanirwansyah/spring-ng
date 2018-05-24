package com.spring.cart.springbootangular.controller;

import com.spring.cart.springbootangular.entity.Role;
import com.spring.cart.springbootangular.request.CreateRoleRequest;
import com.spring.cart.springbootangular.request.GetDetailsByRoleRequest;
import com.spring.cart.springbootangular.request.UpdateByRoleRequest;
import com.spring.cart.springbootangular.response.ErrorReponse;
import com.spring.cart.springbootangular.service.RoleService;
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
@RequestMapping(value = "/api/role")
public class ControllerRole {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> listRole(){
        return Optional.ofNullable(roleService.findAll())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/created")
    public ResponseEntity<Role> create(@Valid @RequestBody CreateRoleRequest request){
        return Optional.ofNullable(roleService.createNewRole(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Role>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/updated")
    public ResponseEntity<Role> update(@Valid @RequestBody UpdateByRoleRequest request){
        return Optional.ofNullable(roleService.updateByRole(request))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Role>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{idOfRole}")
    public ResponseEntity<Role> getDetail(@PathVariable String idOfRole){
        GetDetailsByRoleRequest roleRequest = GetDetailsByRoleRequest
                .builder()
                .idOfRole(idOfRole)
                .build();

        Role role = roleService.getDetailByRole(roleRequest);
        if(role == null){
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Role>(role, HttpStatus.OK);
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
