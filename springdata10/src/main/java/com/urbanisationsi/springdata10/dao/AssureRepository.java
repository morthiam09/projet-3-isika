package com.urbanisationsi.springdata10.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata10.modele.Assure;
import com.urbanisationsi.springdata10.modele.Personne;

import java.time.LocalDate;


public interface AssureRepository extends CrudRepository<Assure, Integer> { // CrudRepository est une interface de Spring Data JPA qui fournit des méthodes pour faire des opérations CRUD (Create, Read, Update, Delete) sur une entité. L'entité est la classe Assure, et la clé primaire de cette entité est de type Integer.
    
     Assure findByNumeroPersonne(Long numeroPersonne);
     List<Assure> findByNomAndPrenom(String nom, String prenom);
     List<Assure> findByNomOrPrenom(String nom, String prenom);
     Personne findByDateNaissance(LocalDate dateNaissance);
     Personne findByDossierMedical(String dossierMedical);
}
