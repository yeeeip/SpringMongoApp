package com.nuzhd.springmongoapp.repo;

import com.nuzhd.springmongoapp.model.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
