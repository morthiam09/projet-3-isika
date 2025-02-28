package com.jrm.reviz.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.jrm.reviz.modele.Stagiaire;

public interface StagiaireRepository extends CrudRepository<Stagiaire, Integer> {
    
    @SuppressWarnings("null")
    List<Stagiaire> findAll();
    @SuppressWarnings("null")
    Optional<Stagiaire> findById(Integer id);
    List<Stagiaire> findByNom(String nom);
    List<Stagiaire> findByPrenom(String prenom);
    List<Stagiaire> findByEmail(String email);
    List<Stagiaire> findByTelephone(String telephone);
    List<Stagiaire> findByNomAndPrenom(String nom, String prenom);

    void deleteById(@SuppressWarnings("null") Integer id);
}
