package com.myapp.tests;

import com.myapp.entities.User;
import com.myapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryTest implements CommandLineRunner {
    private final UserRepository userRepository;
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("mohamed");
        user1.setLastName("mohamed");
        user1.setEmail("mohamed@gmail.com");
        user1.setPassword("*******");

        User user2 = new User();
        user2.setFirstName("Ali");
        user2.setLastName("Ali");
        user2.setEmail("ali@gmail.com");
        user2.setPassword("*******");

        // Add new addresses :
        System.out.println("Saved user 1 : "+ userRepository.save(user1));
        System.out.println("Saved user 2 : "+ userRepository.save(user2));

        // Get All address :
        System.out.println("All users : "+ userRepository.findAll());

        // Get address by id :
        System.out.println("User id=1 : "+ userRepository.findById(1));
        System.out.println("User id=2 : "+ userRepository.findById(2));

        // Update address :
        User user3 = new User();
        user3.setId(2);
        user3.setFirstName("Ali up");
        user3.setLastName("Ali up");
        user3.setEmail("ali_up@gmail.com");
        user3.setPassword("***up***");
        System.out.println("Update user with id=2 : "+ userRepository.save(user3));

        // Delete address
        userRepository.deleteById(1);
        System.out.println("Delete user with id=1 : "+userRepository.findById(1));

    }
}
