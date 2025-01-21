package multiVenderApp.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import multiVenderApp.demo.model.User;
import multiVenderApp.demo.reposiratory.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

