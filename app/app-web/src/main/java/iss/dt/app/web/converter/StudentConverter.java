package iss.dt.app.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import iss.dt.app.core.model.Student;
import iss.dt.app.web.dto.StudentDto;

@Component
public class StudentConverter extends BaseConverter<Student, StudentDto> {

    private static final Logger log = LoggerFactory.getLogger(StudentConverter.class);

    @Override
    public Student convertDtoToModel(StudentDto dto) {
        Student student = new Student(dto.getSerialNumber(),
                dto.getName(),
                dto.getGroupNumber());
        student.setId(dto.getId());
        return student;
    }

    @Override
    public StudentDto convertModelToDto(Student student) {
        StudentDto studentDto = new StudentDto(student.getSerialNumber(),
                student.getName(), student.getGroupNumber());
        studentDto.setId(student.getId());
        return studentDto;
    }
}
