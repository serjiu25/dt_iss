package iss.dt.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import iss.dt.app.core.service.DisciplineService;
import iss.dt.app.web.converter.DisciplineConverter;
import iss.dt.app.web.dto.DisciplineDto;

import java.util.Set;

@RestController
public class DisciplineController {
    //todo: log

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private DisciplineConverter disciplineConverter;

    @RequestMapping(value = "/disciplines")
    Set<DisciplineDto> getAllDisciplines() {
        return disciplineConverter.convertModelsToDtos(
                disciplineService.getAllDisciplines()
        );
    }
}
