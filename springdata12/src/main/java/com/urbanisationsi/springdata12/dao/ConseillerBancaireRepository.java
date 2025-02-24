package com.urbanisationsi.springdata12.dao;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata12.modele.ConseillerBancaire;

public interface ConseillerBancaireRepository extends CrudRepository<ConseillerBancaire, Integer> {

    ConseillerBancaire findByNomOrPrenom(String nom, String prenom);
    ConseillerBancaire findByNumeroBureau(Long numeroBureau);
}
