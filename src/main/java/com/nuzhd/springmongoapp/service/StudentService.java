package com.nuzhd.springmongoapp.service;

import com.nuzhd.springmongoapp.repo.StudentRepository;
import com.nuzhd.springmongoapp.model.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
