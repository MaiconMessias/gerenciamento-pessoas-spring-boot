package com.dio.gerenciamentopessoasspringboot.controller;

import com.dio.gerenciamentopessoasspringboot.dto.request.PersonDTO;
import com.dio.gerenciamentopessoasspringboot.dto.response.MessageResponseDTO;
import com.dio.gerenciamentopessoasspringboot.exception.PersonalNotfoundException;
import com.dio.gerenciamentopessoasspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonalNotfoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonalNotfoundException {
        personService.deleteById(id);
    }

}
