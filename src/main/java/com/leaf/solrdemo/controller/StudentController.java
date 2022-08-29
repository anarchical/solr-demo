package com.leaf.solrdemo.controller;

import com.leaf.solrdemo.entity.Student;
import com.leaf.solrdemo.service.CoreService;
import com.leaf.solrdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YeYaqiao
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CoreService coreService;

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/cores")
    public List<String> getCores() {
        return coreService.core();
    }
}
