package cl.java.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.java.evaluation.dto.UserDto;
import cl.java.evaluation.model.User;
import cl.java.evaluation.service.UserService;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Metodo es para listar todos los usuarios")
    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @ApiOperation(value = "Metodo el cual te permite agregar nuevos usuarios")
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) throws Exception {
        var response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
