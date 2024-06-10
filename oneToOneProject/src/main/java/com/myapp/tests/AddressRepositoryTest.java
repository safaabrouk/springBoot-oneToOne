package com.myapp.tests;

import com.myapp.entities.Address;
import com.myapp.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryTest implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
            Address address1 = new Address();
            address1.setCity("San Francisco");
            address1.setState("CA");
            address1.setZip("20250");
            address1.setStreet("address street");

            Address address2 = new Address();
            address2.setCity("Casablanca");
            address2.setState("MA");
            address2.setZip("20350");
            address2.setStreet("address street 2");

            // Add new addresses :
            System.out.println("Saved address : "+ addressRepository.save(address1));
            System.out.println("Saved address : "+ addressRepository.save(address2));

            // Get All address :
            System.out.println("All addresses : "+ addressRepository.findAll());

            // Get address by id :
            System.out.println("Address id=1 : "+ addressRepository.findById(1));
            System.out.println("Address id=2 : "+ addressRepository.findById(2));

            // Update address :
            Address address3 = new Address();
            address3.setId(2);
            address3.setCity("Casablanca Up");
            address3.setState("MA Up");
            address3.setZip("20350 Up");
            address3.setStreet("address street Up");
            System.out.println("Update address with id=2 : "+ addressRepository.save(address3));

            // Delete address
            addressRepository.deleteById(1);
            System.out.println("Delete address with id=1 : "+addressRepository.findById(1));
    }
}
