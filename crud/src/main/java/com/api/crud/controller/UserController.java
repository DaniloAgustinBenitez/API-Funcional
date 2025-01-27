package com.api.crud.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.crud.model.UserModel;
import com.api.crud.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserServices userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "Se ha eliminado el usuario con id: " + id;
        }else {
            return "No se ha podido eliminar el usuario con id: " + id;
        }
    }
    
    @ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "error"; // Nombre de la vista de error
    }
}

}