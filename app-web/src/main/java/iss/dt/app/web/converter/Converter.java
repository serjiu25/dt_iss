package iss.dt.app.web.converter;


import iss.dt.app.web.dto.BaseDto;

public interface Converter<Model, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

