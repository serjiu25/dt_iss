package iss.dt.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import iss.dt.app.core.model.Student;
import iss.dt.app.core.service.StudentService;
import iss.dt.app.web.converter.StudentConverter;
import iss.dt.app.web.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<StudentDto> getStudents() {
        System.out.println("Got into students");
        log.trace("getStudents");

        List<Student> students = studentService.findAll();

        log.trace("getStudents: students={}", students);

        return new ArrayList<>(studentConverter.convertModelsToDtos(students));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
    public StudentDto updateStudent(
            @PathVariable final Long studentId,
            @RequestBody final StudentDto studentDto) {
        log.trace("updateStudent: studentId={}, studentDtoMap={}", studentId, studentDto);

        Student student = studentService.updateStudent(studentId,
                studentDto.getSerialNumber(),
                studentDto.getName(), studentDto.getGroupNumber());

        StudentDto result = studentConverter.convertModelToDto(student);

        log.trace("updateStudent: result={}", result);

        return result;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    StudentDto saveStudent(@RequestBody StudentDto studentDto) {
        //todo: log
        return studentConverter.convertModelToDto(
                studentService.saveStudent(
                        studentConverter.convertDtoToModel(studentDto)
                )
        );
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        //todo: log
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
