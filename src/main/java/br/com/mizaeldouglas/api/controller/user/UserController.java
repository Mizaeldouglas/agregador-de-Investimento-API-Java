package br.com.mizaeldouglas.api.controller.user;

import br.com.mizaeldouglas.api.dtos.user.CreateUserDTO;
import br.com.mizaeldouglas.api.entity.user.User;
import br.com.mizaeldouglas.api.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO) {
       var userId =  userService.createUser(createUserDTO);
        return ResponseEntity.created(URI.create("/v1/users"+ userId.toString())).build();
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = new User();
        return ResponseEntity.ok(user);
    }


}
