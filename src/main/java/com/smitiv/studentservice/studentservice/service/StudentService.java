package com.smitiv.studentservice.studentservice.service;

import com.smitiv.studentservice.studentservice.mapper.StudentMapper;
import com.smitiv.studentservice.studentservice.model.api.Student;
import com.smitiv.studentservice.studentservice.model.api.StudentResponse;
import com.smitiv.studentservice.studentservice.model.dao.StudentDAO;
import com.smitiv.studentservice.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponse saveStudent(Student student){
        StudentDAO studentDAO = studentMapper.studentToStudentDao(student);
        StudentDAO savedStudentDAO = studentRepository.save(studentDAO);
        return studentMapper.studentDaoToStudentResponse(savedStudentDAO);
    }

    public List<StudentResponse> saveAllStudent(List<Student> student){
        List<StudentDAO> studentDAO = studentMapper.studentToStudentDao(student);
        List<StudentDAO> savedStudentDAO = studentRepository.saveAll(studentDAO);
        return studentMapper.studentDaoToStudentResponse(savedStudentDAO);
    }

    @Transactional
    public void updateStudentById(Student student, Long id){
        StudentDAO studentDAO = studentMapper.studentToStudentDao(student);
        if(studentRepository.existsById(id)) {
            StudentDAO repoStudentDAO = studentRepository.getOne(id);
            repoStudentDAO.setGender(studentDAO.getGender());
            repoStudentDAO.setEducation(studentDAO.getEducation());
            repoStudentDAO.setLocation(studentDAO.getLocation());
            repoStudentDAO.setName(studentDAO.getName());
            StudentDAO savedStudentDAO = studentRepository.save(repoStudentDAO);
            studentMapper.studentDaoToStudentResponse(savedStudentDAO);
        }
    }
}
