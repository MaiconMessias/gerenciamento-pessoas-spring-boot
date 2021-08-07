package com.dio.gerenciamentopessoasspringboot.mapper;

import com.dio.gerenciamentopessoasspringboot.dto.request.PersonDTO;
import com.dio.gerenciamentopessoasspringboot.dto.request.PhoneDTO;
import com.dio.gerenciamentopessoasspringboot.model.Person;
import com.dio.gerenciamentopessoasspringboot.model.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-06T22:40:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Debian)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person person = new Person();

        if ( dto.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( dto.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.setId( dto.getId() );
        person.setFirstName( dto.getFirstName() );
        person.setLastName( dto.getLastName() );
        person.setCpf( dto.getCpf() );
        person.setPhones( phoneDTOListToPhoneList( dto.getPhones() ) );

        return person;
    }

    @Override
    public PersonDTO toDTO(Person dto) {
        if ( dto == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( dto.getId() );
        personDTO.setFirstName( dto.getFirstName() );
        personDTO.setLastName( dto.getLastName() );
        personDTO.setCpf( dto.getCpf() );
        if ( dto.getBirthDate() != null ) {
            personDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getBirthDate() ) );
        }
        personDTO.setPhones( phoneListToPhoneDTOList( dto.getPhones() ) );

        return personDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setPhoneType( phoneDTO.getPhoneType() );
        phone.setNumero( phoneDTO.getNumero() );

        return phone;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setPhoneType( phone.getPhoneType() );
        phoneDTO.setNumero( phone.getNumero() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
