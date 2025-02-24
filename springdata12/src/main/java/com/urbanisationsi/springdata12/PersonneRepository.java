package com.urbanisationsi.springdata12;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata12.modele.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer> {
    
     List<Personne>  findByNumeroPersonne(Long numeroPersonne);
     List<Personne> findByNomAndPrenom(String nom, String prenom);
     Personne findByDateNaissance(LocalDate dateNaissance);

}
