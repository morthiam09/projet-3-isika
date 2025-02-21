package com.urbanisationsi.springdata10.dao;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata10.modele.Assure;

public interface AssureRepository extends CrudRepository<Assure, Integer> { // CrudRepository est une interface de Spring Data JPA qui fournit des méthodes pour faire des opérations CRUD (Create, Read, Update, Delete) sur une entité. L'entité est la classe Assure, et la clé primaire de cette entité est de type Integer.
    
}
