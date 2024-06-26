package com.myapp.tests;

import com.myapp.entities.Address;
import com.myapp.entities.User;
import com.myapp.repositories.AddressRepository;
import com.myapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryTest implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserRepositoryTest(UserRepository userRepository , AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // /*
        // Without cascade
        System.out.println("------------------------- User1/Address1: -------------------------");
        Address address1 = new Address();
        address1.setCity("San Francisco");
        address1.setState("CA");
        address1.setZip("20250");
        address1.setStreet("address street");
        System.out.println("Address 1 : "+addressRepository.save(address1));
        User user1 = new User();
        user1.setFirstName("mohamed");
        user1.setLastName("mohamed");
        user1.setEmail("mohamed@gmail.com");
        user1.setPassword("*******");
        address1.setId(1);
        user1.setAddress(address1);
        System.out.println("User 1 : "+user1);
        User savedUser1 = userRepository.save(user1);
        // Update user_id in address table :
        address1.setUser(savedUser1);
        addressRepository.save(address1);

        System.out.println("------------------------- User2/Address2: -------------------------");
        Address address2 = new Address();
        address2.setCity("Casablanca");
        address2.setState("MA");
        address2.setZip("20350");
        address2.setStreet("address street 2");
        System.out.println("Address 2 : "+addressRepository.save(address2));
        User user2 = new User();
        user2.setFirstName("Ali");
        user2.setLastName("Ali");
        user2.setEmail("ali@gmail.com");
        user2.setPassword("*******");
        address2.setId(2);
        user2.setAddress(address2);
        System.out.println("User 2 : "+user2);
        User savedUser2 = userRepository.save(user2);
        // Update user_id in address table :
        address2.setUser(savedUser2);
        addressRepository.save(address2);

        // Delete address
        //... userRepository.deleteById(1); // Affected user : Ok
        //... addressRepository.deleteById(1); // Affected address : KO
        System.out.println("------------------------- Delete user1 : --------------------------");
        // Update idUser in Address with null
        address1.setUser(null);
        addressRepository.save(address1);
        userRepository.delete(user1);
        addressRepository.deleteById(1);
        System.out.println("Delete user with id=1 : "+userRepository.findById(1));


        // With cascade
        /*
        System.out.println("------------------------- User1/Address1: -------------------------");
        Address address1 = new Address();
        address1.setCity("San Francisco");
        address1.setState("CA");
        address1.setZip("20250");
        address1.setStreet("address street");
        User user1 = new User();
        user1.setFirstName("mohamed");
        user1.setLastName("mohamed");
        user1.setEmail("mohamed@gmail.com");
        user1.setPassword("*******");
        user1.setAddress(address1);
        System.out.println("User 1 : "+user1);


        System.out.println("------------------------- User2/Address2: -------------------------");
        Address address2 = new Address();
        address2.setCity("Casablanca");
        address2.setState("MA");
        address2.setZip("20350");
        address2.setStreet("address street 2");
        User user2 = new User();
        user2.setFirstName("Ali");
        user2.setLastName("Ali");
        user2.setEmail("ali@gmail.com");
        user2.setPassword("*******");
        user2.setAddress(address2);
        System.out.println("User 2 : "+user2);


        // Add new users :
        System.out.println("------------------------- Save(User/Address): ---------------------");
        System.out.println("Saved user 1 : "+ userRepository.save(user1));
        System.out.println("Saved user 2 : "+ userRepository.save(user2));


        // Get All users :
        System.out.println("------------------------- GetAll(Users/Addresses): ----------------");
        List<User> users = userRepository.findAll();
        int index = 1;
        for (User user : users) {
            System.out.println("User N°"+index+" : "+ user);
            index++;
        }



        // Update user :
        System.out.println("------------------------- Update user1 : id_Address will be 3 -----");
        Address address3 = new Address();
        address3.setCity("Casablanca");
        address3.setState("MA");
        address3.setZip("20350");
        address3.setStreet("address street 3");
        User user3 = new User();
        user3.setId(1);
        user3.setFirstName("mohamed up");
        user3.setLastName("mohamed up");
        user3.setEmail("mohamed_up@gmail.com");
        user3.setPassword("***up***");
        user3.setAddress(address3);
        System.out.println("Update user with id=1 : "+ userRepository.save(user3));

        //
        System.out.println("------------------------- User1 & address3 will be updated --------");
        address3.setId(3);
        address3.setCity("Casablanca up");
        address3.setState("MA up");
        address3.setZip("20350 up");
        address3.setStreet("address street 3 up");
        user3.setFirstName("mohamed up2");
        user3.setLastName("mohamed up2");
        user3.setEmail("mohamed_up2@gmail.com");
        user3.setPassword("***up2***");
        System.out.println("Update user with id=1 : "+ userRepository.save(user3));

        System.out.println("------------------------- Update user2 : id_Address will be null --");
        User user4 = new User();
        user4.setId(2);
        user4.setFirstName("Ali up");
        user4.setLastName("Ali up");
        user4.setEmail("ali_up@gmail.com");
        user4.setPassword("***up***");
        System.out.println("Update user with id=2 : "+ userRepository.save(user4));


        // Delete address


        System.out.println("------------------------- Delete Address1 (Ok): -------------------");
        addressRepository.deleteById(1); // No affected address : Ok
        // addressRepository.deleteById(3); // Affected address : KO
        System.out.println("------------------------- Delete user1/Address3 : -----------------");
        userRepository.deleteById(1);
        System.out.println("Delete user with id=1 : "+userRepository.findById(1));
        */
    }
}
