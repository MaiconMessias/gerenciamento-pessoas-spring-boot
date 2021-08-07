package com.dio.gerenciamentopessoasspringboot.repository;

import com.dio.gerenciamentopessoasspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
