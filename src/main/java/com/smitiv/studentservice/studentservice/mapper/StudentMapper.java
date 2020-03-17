package com.smitiv.studentservice.studentservice.mapper;

import com.smitiv.studentservice.studentservice.model.api.Student;
import com.smitiv.studentservice.studentservice.model.api.StudentResponse;
import com.smitiv.studentservice.studentservice.model.dao.StudentDAO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDAO studentToStudentDao(Student student);
    StudentResponse studentDaoToStudentResponse(StudentDAO studentDAO);

    List<StudentDAO> studentToStudentDao(List<Student> student);
    List<StudentResponse> studentDaoToStudentResponse(List<StudentDAO> studentDAO);

}
