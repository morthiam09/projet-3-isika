package com.urbanisationsi.springapirest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springapirest.modele.Assure;

import java.time.LocalDate;


public interface AssureRepository extends CrudRepository<Assure, Integer> { // CrudRepository est une interface de Spring Data JPA qui fournit des méthodes pour faire des opérations CRUD (Create, Read, Update, Delete) sur une entité. L'entité est la classe Assure, et la clé primaire de cette entité est de type Integer.
    
     List<Assure>  findByNumeroPersonne(Long numeroPersonne);
     List<Assure> findByNomAndPrenom(String nom, String prenom);
     List<Assure> findByNomOrPrenom(String nom, String prenom);
     List<Assure> findByDateNaissance(LocalDate dateNaissance);
     List<Assure> findByDossierMedical(String dossierMedical);
     // rechercher par un nom contenant un chain de caractère
     List<Assure> findByNomContaining(String nom);
     List<Assure> findByNumeroAssure(Long numeroAssure);
     List<Assure> findByDateNaissanceBefore(LocalDate date);
     // Suppression d'un assure
     void deleteByNumeroPersonne(Long numeroPersonne);
     // recherche par id
     Optional<Assure> findById(Integer id);

}
