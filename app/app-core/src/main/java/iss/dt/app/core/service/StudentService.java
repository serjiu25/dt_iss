package iss.dt.app.core.service;

import iss.dt.app.core.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student updateStudent(Long studentId, String serialNumber, String name, Integer groupNumber);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

}
