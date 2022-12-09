package com.example.microservice.controller;

import com.example.microservice.model.UserDTO;
import jakarta.servlet.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping("/users")
public class UserControllerRest {

    //ResponseEntity me permite devolver estado explicito de acuerdo a los errores en el codigo
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO>  getUserById(@PathVariable Integer id){

        System.out.println("Recovery user by id");

        UserDTO userDTO = new UserDTO(1,"Jorman");
        userDTO.setLastname("Lopez");

        //Esta linea de codigo incorpora navegacion Hateoas
        Link withSelfRel = linkTo(methodOn(UserControllerRest.class).getUserById(userDTO.getId())).withSelfRel();
        userDTO.add(withSelfRel);

        return ResponseEntity.ok(userDTO) ;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {

        System.out.println("Creating user " + userDTO.getName());


        //codigo para obtener la URI
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){

        System.out.println("Updating user");

        return ResponseEntity.ok(userDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable  Integer id) {

        System.out.println("Delete user by id");

        return ResponseEntity.ok(null);

    }

}

