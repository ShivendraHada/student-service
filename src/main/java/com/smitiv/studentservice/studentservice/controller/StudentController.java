package com.smitiv.studentservice.studentservice.controller;

import com.smitiv.studentservice.studentservice.model.api.Student;
import com.smitiv.studentservice.studentservice.model.api.StudentResponse;
import com.smitiv.studentservice.studentservice.model.dao.StudentDAO;
import com.smitiv.studentservice.studentservice.repository.StudentRepository;
import com.smitiv.studentservice.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    // saving student record
    @PostMapping(value = "/new")
    public StudentResponse saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // saving bulk student record
    @PostMapping(value = "/new/bulk")
    public List<StudentResponse> saveAllStudent(@RequestBody List<Student> student) {
        return studentService.saveAllStudent(student);
    }

    // retrieve all the data of the student
    @GetMapping(value = "/all")
    public List<StudentDAO> getAll() {
        return studentRepository.findAll();
    }

    // update student data by passing student id
    @PutMapping(value = "/update/{id}")
    public void updateData(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudentById(student, id);
    }

}
