package com.urbanisationsi.springdata10.dao;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata10.modele.ConseillerBancaire;

public interface ConseillerBancaireRepository extends CrudRepository<ConseillerBancaire, Integer> {

    ConseillerBancaire findByNomOrPrenom(String nom, String prenom);
    ConseillerBancaire findByNumeroBureau(Long numeroBureau);
}
