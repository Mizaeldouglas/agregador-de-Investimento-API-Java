package br.com.mizaeldouglas.api.service.user;

import br.com.mizaeldouglas.api.dtos.user.CreateUserDTO;
import br.com.mizaeldouglas.api.entity.user.User;
import br.com.mizaeldouglas.api.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDTO createUserDTO) {
        var entity = new User(
                UUID.randomUUID(),
                createUserDTO.username(),
                createUserDTO.email(),
                createUserDTO.password(),
                Instant.now(),
                null
        );

        var userSaved =  userRepository.save(entity);
        return userSaved.getUserId();
    }
}