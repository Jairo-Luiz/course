package com.educandoweb.course.controles;

import com.educandoweb.course.entidades.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){

        User user = new User (1L, "Jairo", "jairo@gmail.com", "930983613", "123456");

        return ResponseEntity.ok().body( user );
    }
}