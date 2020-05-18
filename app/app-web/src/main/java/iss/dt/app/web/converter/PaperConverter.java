package iss.dt.app.web.converter;

import iss.dt.app.core.model.Paper;
import iss.dt.app.web.dto.BaseDto;
import iss.dt.app.web.dto.PaperDto;

public class PaperConverter implements Converter<Paper, PaperDto> {
    /*
    private String name;
    private String abstractURL;
    private String fullURL;
    private String keywords;
    private String topics;
    private String other_authors;
     */
    @Override
    public Paper convertDtoToModel(PaperDto dto) {
        Paper paper=new Paper(dto.getId()
                             ,dto.getName()
                             ,dto.getAbstractURL()
                             ,dto.getFullURL()
                             ,dto.getKeywords()
                             ,dto.getTopics()
                             ,dto.getOther_authors());

        return paper;
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
