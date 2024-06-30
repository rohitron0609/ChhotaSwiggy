package com.decx.userinfo.service;

import com.decx.userinfo.dto.UserDTO;
import com.decx.userinfo.entity.User;
import com.decx.userinfo.mapper.UserMapper;
import com.decx.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<UserDTO> fetchUserById(Integer id) {
         Optional<User> userWithId = userRepository.findById(id);
         if(userWithId.isPresent())
             return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(userWithId.get()), HttpStatus.OK);
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }
}
