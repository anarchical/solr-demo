package com.leaf.solrdemo.service;

import com.leaf.solrdemo.entity.Student;
import com.leaf.solrdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeYaqiao
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id){
        return studentRepository.findStudentById(id);
    }
}
