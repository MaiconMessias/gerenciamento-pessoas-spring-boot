package com.dio.gerenciamentopessoasspringboot.mapper;

import com.dio.gerenciamentopessoasspringboot.dto.request.PersonDTO;
import com.dio.gerenciamentopessoasspringboot.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
