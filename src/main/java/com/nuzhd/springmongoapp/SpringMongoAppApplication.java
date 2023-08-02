package com.nuzhd.springmongoapp;

import com.github.javafaker.Faker;
import com.nuzhd.springmongoapp.model.Address;
import com.nuzhd.springmongoapp.model.Gender;
import com.nuzhd.springmongoapp.model.student.Student;
import com.nuzhd.springmongoapp.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringMongoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            if (repository.findAll().size() == 0) {
                Faker faker = new Faker();
                for (int i = 0; i < 10; i++) {
                    Address fakeAddress = new Address(faker.address().country(), faker.address().city(), faker.address().zipCode());
                    Student fakeStudent = new Student(faker.name().firstName(),
                            faker.name().lastName(),
                            faker.internet().emailAddress(),
                            List.of(Gender.FEMALE, Gender.MALE).get(new Random().nextInt(2)),
                            fakeAddress,
                            List.of("Math", "CS", "Sports"),
                            new BigDecimal(new Random().nextInt(100)),
                            LocalDateTime.now());

                    repository.save(fakeStudent);
                }
            }
        };
    }
}
