package com.dio.gerenciamentopessoasspringboot.service;

import com.dio.gerenciamentopessoasspringboot.dto.request.PersonDTO;
import com.dio.gerenciamentopessoasspringboot.dto.response.MessageResponseDTO;
import com.dio.gerenciamentopessoasspringboot.exception.PersonalNotfoundException;
import com.dio.gerenciamentopessoasspringboot.mapper.PersonMapper;
import com.dio.gerenciamentopessoasspringboot.model.Person;
import com.dio.gerenciamentopessoasspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person person = personMapper.toModel(personDTO);
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create Person by id " + savePerson.getId())
                .build();
    }


    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonalNotfoundException {
        Person person = verifiIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonalNotfoundException {
        verifiIfExists(id);

        personRepository.deleteById(id);
    }

    private Person verifiIfExists(Long id) throws PersonalNotfoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonalNotfoundException(id));
    }
}
