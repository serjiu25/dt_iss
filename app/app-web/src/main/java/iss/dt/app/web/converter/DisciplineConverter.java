package iss.dt.app.web.converter;

import org.springframework.stereotype.Component;
import iss.dt.app.core.model.Discipline;
import iss.dt.app.web.dto.DisciplineDto;

@Component
public class DisciplineConverter extends BaseConverter<Discipline, DisciplineDto> {
    @Override
    public Discipline convertDtoToModel(DisciplineDto dto) {

        throw new RuntimeException("not yet implemented");
    }

    @Override
    public DisciplineDto convertModelToDto(Discipline discipline) {
        DisciplineDto dto = new DisciplineDto(discipline.getName(),
                discipline.getTeacher(),
                discipline.getCredits());
        dto.setId(discipline.getId());
        return dto;
    }
}
