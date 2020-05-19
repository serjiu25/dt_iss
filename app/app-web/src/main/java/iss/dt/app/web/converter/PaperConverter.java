package iss.dt.app.web.converter;

import iss.dt.app.core.model.Paper;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.PaperDto;
import org.springframework.stereotype.Component;

@Component
public class PaperConverter extends BaseConverter<Paper, PaperDto> {

    @Override
    public Paper convertDtoToModel(PaperDto dto) {
        return new Paper(dto.getId()
                             ,dto.getName()
                             ,dto.getAbstractURL()
                             ,dto.getFullURL()
                             ,dto.getKeywords()
                             ,dto.getTopics()
                             ,dto.getOther_authors());
    }

    @Override
    public PaperDto convertModelToDto(Paper paper) {
        PaperDto paperDto=new PaperDto(paper.getName()
                                      ,paper.getAbstractURL()
                                      ,paper.getFullURL()
                                      ,paper.getKeywords()
                                      ,paper.getTopics()
                                      ,paper.getOther_authors());

        paperDto.setId(paper.getId());

        return paperDto;
    }
}
