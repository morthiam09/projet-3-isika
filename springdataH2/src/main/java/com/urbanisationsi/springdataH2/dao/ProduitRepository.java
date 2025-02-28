package com.urbanisationsi.springdataH2.dao;

import org.springframework.data.repository.CrudRepository;
import com.urbanisationsi.springdataH2.modele.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

    
}
