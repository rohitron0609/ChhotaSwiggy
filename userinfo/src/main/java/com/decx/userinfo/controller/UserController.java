package com.decx.userinfo.controller;

import com.decx.userinfo.dto.UserDTO;
import com.decx.userinfo.entity.User;
import com.decx.userinfo.mapper.UserMapper;
import com.decx.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUser/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer id){
        return userService.fetchUserById(id);
    }
}
